docker build -f Dockerfile.build -t buildenv .
docker run -v `pwd`:/src buildenv:latest
docker-compose build
