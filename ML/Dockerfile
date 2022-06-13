FROM pytorch/pytorch:1.4-cuda10.1-cudnn7-runtime

# Setuptools
RUN chmod 1777 /tmp
RUN apt-get update && apt-get install -y python3-pip

ADD ./ /app/
WORKDIR /app/

RUN pip install -r requirements.txt
CMD python main.py
