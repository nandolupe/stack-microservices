package dao

import (
	"log"

	. "github.com/nandolup/beneficiario-golang/models"
	mgo "gopkg.in/mgo.v2"
	"gopkg.in/mgo.v2/bson"
)

type BeneficiarioDAO struct {
	Server   string
	Database string
}

var db *mgo.Database

const (
	COLLECTION = "beneficiario"
)

func (m *BeneficiarioDAO) Connect() {
	session, err := mgo.Dial(m.Server)
	
	if err != nil {
		log.Fatal(err)
	}
	db = session.DB(m.Database)
}

func (m *BeneficiarioDAO) GetAll() ([]Beneficiario, error) {
	var beneficiarios []Beneficiario
	err := db.C(COLLECTION).Find(bson.M{}).All(&beneficiarios)
	return beneficiarios, err
}

func (m *BeneficiarioDAO) GetByID(id string) (Beneficiario, error) {
	var beneficiario Beneficiario
	err := db.C(COLLECTION).FindId(bson.ObjectIdHex(id)).One(&beneficiario)
	return beneficiario, err
}

func (m *BeneficiarioDAO) Create(beneficiario Beneficiario) error {
	err := db.C(COLLECTION).Insert(&beneficiario)
	return err
}

func (m *BeneficiarioDAO) Delete(id string) error {
	err := db.C(COLLECTION).RemoveId(bson.ObjectIdHex(id))
	return err
}

func (m *BeneficiarioDAO) Update(id string, beneficiario Beneficiario) error {
	err := db.C(COLLECTION).UpdateId(bson.ObjectIdHex(id), &beneficiario)
	return err
}

