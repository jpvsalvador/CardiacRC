<template>
  <div class="main-div">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
    <Topbar/>
      <b-container>
        <h1>Patient List:</h1>
        <b-table striped over outlined :items="patients" :fields="fields" class="mt-3" >
          <template v-slot:cell(actions)="row">
            <nuxt-link class="btn btn-primary btn-xs" :to="`/patients/${row.item.username}/details`">
                <i class="fas fa-clipboard-list"></i>
            </nuxt-link>
            <nuxt-link class="btn btn-secondary btn-xs" :to="`/patients/${row.item.username}/update`">
                <i class="fas fa-pen"></i>
            </nuxt-link>
            <button class="btn btn-danger btn-xs"  @click.prevent="deletePatient(row.item.username)">
                <i class="fas fa-trash"></i>
            </button>
          </template>
      </b-table>
      </b-container>
      <b-container>
          <nuxt-link to="/" class="btn btn-primary" >Back</nuxt-link>
          <nuxt-link to="/patients/create" class="btn btn-secondary">Create a New Patient</nuxt-link>
      </b-container>
  </div>
</template>

<script>
export default {
  data () {
    return {
      fields: ['username', 'name', 'email', 'healthNumber', 'associatedProfessional', 'actions'],
      patients: []
    }
  },
  created () {
    this.$axios.$get('/api/patients').then((patients) => { this.patients = patients })
  } ,
  methods: {
    deletePatient(username) {
        this.$axios.$delete(`/api/patients/${username}`)
        .then(() => {
          window.location.reload();
        })
    }
  }
}
</script>

<style scoped>

</style>
