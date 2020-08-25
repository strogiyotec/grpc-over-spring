package com.grpc;

import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;

@Singleton
public final class GreatingEndpoint extends GreaterGrpc.GreaterImplBase {

    private static final Logger log = LoggerFactory.getLogger(GreatingEndpoint.class);

    @Override
    public void sayHello(final HelloRequest request, final StreamObserver<HelloReply> responseObserver) {
        final String name = request.getName();
        log.info("Msg {}", name);
        responseObserver.onNext(HelloReply.newBuilder().setMessage("Hello " + name).build());
        responseObserver.onCompleted();
    }
}
