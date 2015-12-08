FROM ubuntu:14.04
USER root
RUN apt-get update && apt-get -y install \
	python python-dev python-distribute python-pip g++ make
#RUN pip install json
RUN mkdir -p /isolate
RUN mkdir -p /dropzone
RUN mkdir -p /helper
VOLUME /tmp/input
VOLUME /tmp/output 
VOLUME /tmp/compile
#VOLUME /tmp/submission
COPY isolate /isolate
COPY helper /helper
WORKDIR /isolate
RUN make
WORKDIR /helper
