const uuidv4 = require('uuid/v4');

module.exports = app => {
  const beneficiariosDB = app.data.beneficiarios;
  const healthDataDB = app.data.health;
  const controller = {};

  const {
	  beneficiarios: beneficiariosMock,
  } = beneficiariosDB;
    
  const {
    healthData: healthDataUP,
  } = healthDataDB;

  controller.listarTodosBeneficiarios = (req, res) => res.status(200).json(beneficiariosDB);

  controller.salvarBeneficiario = (req, res) => {
    beneficiariosMock.data.push({
      id: uuidv4(),
      parentId: uuidv4(),
      nome: req.body.nome,
      dataNascimento: req.body.dataNascimento,
      email: req.body.email,
      sexo: req.body.sexo,
      estado: req.body.estado,
      createdAt: new Date()
    });

    res.status(201).json(beneficiariosMock);
  };

  controller.removerBeneficiario = (req, res) => {
    const {
    	beneficiarioId,
    } = req.params;

    const foundCustomerIndex = beneficiariosMock.data.findIndex(customer => customer.id === beneficiarioId);

    if (foundCustomerIndex === -1) {
      res.status(404).json({
        message: 'Beneficiario não encontrado na base.',
        success: false,
        beneficiarios: beneficiariosMock,
      });
    } else {
      beneficiariosMock.data.splice(foundCustomerIndex, 1);
      res.status(200).json({
        message: 'Beneficiario encontrado e deletado com sucesso!',
        success: true,
        beneficiarios: beneficiariosMock,
      });
    }
  };

  controller.atualizarBeneficiario = (req, res) => {
    const { 
    	beneficiarioId,
    } = req.params;

    const foundCustomerIndex = beneficiariosMock.data.findIndex(customer => customer.id === beneficiarioId);

    if (foundCustomerIndex === -1) {
      res.status(404).json({
        message: 'Beneficiario não encontrado na base.',
        success: false,
        beneficiarios: beneficiariosMock,
      });
    } else {
      const newCustomer = {
        id: beneficiarioId ,
        parentId: req.body.parentId,
        nome: req.body.nome,
        dataNascimento: req.body.dataNascimento,
        email: req.body.email,
        sexo: req.body.sexo,
        estado: req.body.estado,
        createdAt: new Date()
      };
      
      beneficiariosMock.data.splice(foundCustomerIndex, 1, newCustomer);
      
      res.status(200).json({
        message: 'Beneficiario encontrado e atualizado com sucesso!',
        success: true,
        beneficiarios: beneficiariosMock,
      });
    }
  }
    
   controller.health = (req, res) => {
    res.status(200).json(healthDataDB);
  };

  return controller;
}
