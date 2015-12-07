FROM ubuntu:14.04
USER root
RUN apt-get update && apt-get -y install \
	gcc g++ python make
RUN mkdir -p /isolate
RUN mkdir -p /dropzone
VOLUME /dropzone
COPY isolate /isolate
WORKDIR /isolate
RUN make
