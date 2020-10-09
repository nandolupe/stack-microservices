package movierouter

import (
	"encoding/json"
	"net/http"

	"github.com/gorilla/mux"
	. "github.com/nandolup/beneficiario-golang/config/dao"
	. "github.com/nandolup/beneficiario-golang/models"
	"gopkg.in/mgo.v2/bson"
)

var dao = BeneficiarioDAO{}

func respondWithError(w http.ResponseWriter, code int, msg string) {
	respondWithJson(w, code, map[string]string{"error": msg})
}

func respondWithJson(w http.ResponseWriter, code int, payload interface{}) {
	response, _ := json.Marshal(payload)
	w.Header().Set("Content-Type", "application/json")
	w.WriteHeader(code)
	w.Write(response)
}

func GetAll(w http.ResponseWriter, r *http.Request) {
	beneficiarios, err := dao.GetAll()
	if err != nil {
		respondWithError(w, http.StatusInternalServerError, err.Error())
		return
	}
	respondWithJson(w, http.StatusOK, beneficiarios)
}

func GetByID(w http.ResponseWriter, r *http.Request) {
	params := mux.Vars(r)
	beneficiario, err := dao.GetByID(params["id"])
	if err != nil {
		respondWithError(w, http.StatusBadRequest, "Invalid Movie ID")
		return
	}
	respondWithJson(w, http.StatusOK, beneficiario)
}

func Create(w http.ResponseWriter, r *http.Request) {
	defer r.Body.Close()
	var beneficiario Beneficiario
	if err := json.NewDecoder(r.Body).Decode(&beneficiario); err != nil {
		respondWithError(w, http.StatusBadRequest, "Invalid request payload")
		return
	}
	beneficiario.ID = bson.NewObjectId()
	if err := dao.Create(beneficiario); err != nil {
		respondWithError(w, http.StatusInternalServerError, err.Error())
		return
	}
	respondWithJson(w, http.StatusCreated, beneficiario)
}

func Update(w http.ResponseWriter, r *http.Request) {
	defer r.Body.Close()
	params := mux.Vars(r)
	var beneficiario Beneficiario
	if err := json.NewDecoder(r.Body).Decode(&beneficiario); err != nil {
		respondWithError(w, http.StatusBadRequest, "Invalid request payload")
		return
	}
	if err := dao.Update(params["id"], beneficiario); err != nil {
		respondWithError(w, http.StatusInternalServerError, err.Error())
		return
	}
	respondWithJson(w, http.StatusOK, map[string]string{"result": beneficiario.Nome + " atualizado com sucesso!"})
}

func Delete(w http.ResponseWriter, r *http.Request) {
	defer r.Body.Close()
	params := mux.Vars(r)
	if err := dao.Delete(params["id"]); err != nil {
		respondWithError(w, http.StatusInternalServerError, err.Error())
		return
	}
	respondWithJson(w, http.StatusOK, map[string]string{"result": "success"})
}
