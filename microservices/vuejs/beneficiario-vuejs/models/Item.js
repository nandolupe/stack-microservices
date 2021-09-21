// Item.js

var mongoose = require('mongoose');
var Schema = mongoose.Schema;

// Define collection and schema for Items
var Item = new Schema({
  carteirinha: {
    type: String
  },
  nomeBeneficiario: {
    type: String
  },
  tipoBeneficiario: {
    type: String
  }
},{
    collection: 'items'
});

module.exports = mongoose.model('Item', Item);
