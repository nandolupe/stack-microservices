package models

import "gopkg.in/mgo.v2/bson"

type Beneficiario struct {
	ID          bson.ObjectId `bson:"_id" json:"id"`
	Nome        string        `bson:"nome" json:"nome"`
	Sexo        string        `bson:"sexo" json:"sexo"`
	Estado      string        `bson:"estado" json:"estado"`
	Active      bool          `bson:"active" json:"active"`
}
