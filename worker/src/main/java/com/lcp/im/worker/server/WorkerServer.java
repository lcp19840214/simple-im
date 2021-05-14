package com.lcp.im.worker.server;


import com.lcp.im.framework.server.Server;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * desc:    <br/>
 *
 * @author lichunpeng
 * @since 2021/5/12-10:30
 */
public class WorkerServer extends AbstractWorkerServer implements Server {

  private Channel channel;

  // private SimpleChannelInboundHandler<String> stringHandler = new StringHandler();
  //    private ByteToMessageDecoder byteToStringDecoder = new ByteToStringDecoder();

  private final int bossThreadCount;
  private final int workerThreadCount;
  private final int port;

  public WorkerServer(int bossThreadCount, int workerThreadCount, int port) {
    this.bossThreadCount = bossThreadCount;
    this.workerThreadCount = workerThreadCount;
    this.port = port;
  }

  /**
   * 服务启动
   *
   * @return
   */
  @Override
  public boolean start() {

    long startTime = System.currentTimeMillis();

    EventLoopGroup bossGroup = new NioEventLoopGroup(bossThreadCount);
    EventLoopGroup workerGroup = new NioEventLoopGroup(workerThreadCount);

    try {
      ServerBootstrap serverBootstrap = new ServerBootstrap();
      serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
          .option(ChannelOption.SO_BACKLOG, 128)
          .childOption(ChannelOption.SO_KEEPALIVE, true)
          .childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            public void initChannel(SocketChannel socketChannel) {
              ChannelPipeline channelPipeline = socketChannel.pipeline();
              // channelPipeline.addLast(new ByteToStringDecoder());
              // channelPipeline.addLast(stringHandler);
            }
          });

      ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
      channel = channelFuture.channel();
      long endTime = System.currentTimeMillis();

      channelFuture.addListener((ChannelFutureListener) future -> {
        if (future.isDone()) {
          logger.info("worker server start done in {}ms , port:{}", (endTime - startTime), port);
        } else if (future.isSuccess()) {
          logger.info("success");
        }
      });

      channel.closeFuture().sync();

    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      workerGroup.shutdownGracefully();
      bossGroup.shutdownGracefully();
    }

    return true;
  }

  /**
   * 服务停止
   *
   * @return
   */
  @Override
  public boolean stop() {
    return true;
  }
}
