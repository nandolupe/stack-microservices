// Create.vue

<template>
  <div class="container">
        <div class="card">
            <div class="card-header">
                <h3>Add Item</h3>
            </div>
            <div class="card-body">
                <form v-on:submit.prevent="addItem">
                    <div class="form-group">
                        <label>Carteirinha:</label>
                        <input type="text" class="form-control" v-model="item.carteirinha"/>
                    </div>
                    <div class="form-group">
                        <label>Nome Beneficiario:</label>
                        <input type="text" class="form-control" v-model="item.nomeBeneficiario"/>
                    </div>
                    <div class="form-group">
                        <label>Tipo Beneficiario:</label>
                        <input type="text" class="form-control" v-model="item.tipoBeneficiario"/>
                    </div>
                    <div class="form-group">
                        <input type="submit" class="btn btn-primary" value="Add Item"/>
                    </div>
                </form>
            </div>
        </div>
    </div>
</template>

<script>
export default {
  components: {
  },
  data() {
      return {
          item: {}
      }
  },
  methods: {
      addItem() {
           let uri = 'http://localhost:4000/items/add';
            this.axios.post(uri, this.item).then((response) => {
                console.log(response.data)
                this.$router.push({name: 'Index'});
            });
        }
    }
}
</script>
