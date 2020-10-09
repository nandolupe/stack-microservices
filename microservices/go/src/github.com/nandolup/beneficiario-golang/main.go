package main

import (
	"fmt"
	"log"
	"net/http"

	"github.com/gorilla/mux"
	. "github.com/nandolup/beneficiario-golang/config"
	. "github.com/nandolup/beneficiario-golang/config/dao"
	beneficiariorouter "github.com/nandolup/beneficiario-golang/router"
    "github.com/ArthurHlt/go-eureka-client/eureka"
)

var dao = BeneficiarioDAO{}
var config = Config{}

func init() {
	config.Read()

	dao.Server = config.Server
	dao.Database = config.Database
	dao.Connect()
}

func main() {

    client := eureka.NewClient([]string{
		"http://localhost:8761/eureka", //From a spring boot based eureka server
	})
	instance := eureka.NewInstanceInfo("beneficiario-golang", "beneficiario-golang", "127.0.0.1", 3000, 30, false) //Create a new instance to register
	instance.Metadata = &eureka.MetaData{
		Map: make(map[string]string),
	}
	instance.Metadata.Map["foo"] = "bar" //add metadata for example
	client.RegisterInstance("beneficiario-golang", instance) // Register new instance in your eureka(s)
	client.GetApplication(instance.App) // retrieve the application "test"
	client.GetInstance(instance.App, instance.HostName) // retrieve the instance from "test.com" inside "test"" app
	client.SendHeartbeat(instance.App, instance.HostName) // say to eureka that your app is alive (here you must send heartbeat before 30 sec)

	r := mux.NewRouter()
	r.HandleFunc("/beneficiario", beneficiariorouter.GetAll).Methods("GET")
	r.HandleFunc("/beneficiario/{id}", beneficiariorouter.GetByID).Methods("GET")
	r.HandleFunc("/beneficiario", beneficiariorouter.Create).Methods("POST")
	r.HandleFunc("/beneficiario/{id}", beneficiariorouter.Update).Methods("PUT")
	r.HandleFunc("/beneficiario/{id}", beneficiariorouter.Delete).Methods("DELETE")

	var port = ":3000"
	fmt.Println("Server running in port:", port)
	log.Fatal(http.ListenAndServe(port, r))
}  
