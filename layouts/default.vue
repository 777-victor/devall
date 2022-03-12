<template>
  <v-app dark>
    <br />
    <v-main>
      <v-container>
        <Nuxt />
      </v-container>
    </v-main>
    <br />
    <v-footer
      :absolute="!fixed"
      app
    >
      <span>&copy;Victor Boaventura {{ new Date().getFullYear() }} </span>
    </v-footer>
  </v-app>
</template>

<script>
export default {
  name: 'DefaultLayout',
  data () {
    return {
      clipped: false,
      drawer: false,
      fixed: false,
      items: [
        {
          icon: 'mdi-apps',
          title: 'Welcome',
          to: '/'
        },
        {
          icon: 'mdi-chart-bubble',
          title: 'Inspire',
          to: '/inspire'
        }
      ],
      miniVariant: false,
      right: true,
      rightDrawer: false,
      title: 'Vuetify.js'
    }
  }
}
</script>
