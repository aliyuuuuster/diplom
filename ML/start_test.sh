docker build -t sketch_recognition .
nvidia-docker run -ti -v $(pwd):/app -p 8889:8889 --name test_run_sketch_recognition sketch_recognition bash
docker rm test_run_sketch_recognition
