module.exports = app => {
  const controller = app.controllers.beneficiarioController;

  app.route('/beneficiario')
    .get(controller.listarTodosBeneficiarios)
    .post(controller.salvarBeneficiario);

  app.route('/beneficiario/:beneficiarioId')
    .delete(controller.removerBeneficiario)
    .put(controller.atualizarBeneficiario);

  app.route('/health')
    .get(controller.health)
}
