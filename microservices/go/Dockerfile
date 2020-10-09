FROM golang

ENV GOPATH=/app

COPY . /app

#RUN go get github.com/BurntSushi/toml gopkg.in/mgo.v2 github.com/gorilla/mux github.com/ArthurHlt/go-eureka-client##

CMD go run /app/src/github.com/nandolup/examples/http-server-example.go

EXPOSE 8090

