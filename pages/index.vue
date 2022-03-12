<template>
  <v-row justify="center" align="center">
    <v-col cols="12">
      <v-card class="mx-auto">
        <v-card-text>
          <v-form
            @submit.prevent="listPosts()"
            class="d-flex flex-wrap justify-content-space-around"
          >
            <v-text-field
              outlined
              label="Pesquisar"
              placeholder="Digite o titulo ou resumo de um post"
              color="indigo"
              v-model="searchOptions.search"
            >
            </v-text-field>

            <v-btn class="ml-2" color="indigo" fab dark type="submit">
              <v-icon dark> mdi-magnify </v-icon>
            </v-btn>
          </v-form>
        </v-card-text>
      </v-card>
    </v-col>

    <v-col cols="12" sm="12" md="6" lg="4" v-for="post in posts" :key="post.id">
      <v-hover v-slot="{ hover }" open-delay="200">
        <v-card
          :elevation="hover ? 16 : 2"
          :class="{ 'on-hover': hover }"
          class="mx-auto"
          max-height="400px"
        >
          <v-card-title v-text="post.blog.nome"></v-card-title>
          <v-card-text>
            <v-img
              :src="
                post.thumbnail == null
                  ? 'https://opendoormls.com/images/no-data.png'
                  : post.thumbnail
              "
              @click="referSite(post)"
              style="
                max-width: 100%;
                min-width: 100%;
                max-height: 200px;
                min-height: 200px;
                cursor: pointer;
              "
            ></v-img>
            <div class="text--primary">
              {{ post.titulo }}
            </div>
          </v-card-text>
          <v-card-actions>
            <span class="subheading"
              ><h6>{{ post.dataPublicacao }}</h6></span
            >

            <v-spacer></v-spacer>

            <v-btn icon @click="referSite(post)">
              <v-icon>mdi-cursor-pointer</v-icon>
            </v-btn>
            <span class="subheading mr-2">{{ post.cliques }}</span>

            <v-btn icon @click="referSite(post)">
              <v-icon>mdi-home-export-outline</v-icon>
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-hover>
    </v-col>
    <br />
    <div class="text-center" v-if="hasMore">
      <v-chip @click="listPosts(++page)"> Carregar mais... </v-chip>
    </div>
    <br />
    <v-snackbar v-model="toast" shaped>
      {{ toastMensagem }}
      <template v-slot:action="{ attrs }">
        <v-btn color="indigo" text v-bind="attrs" @click="toast = false"
          >Ok</v-btn
        >
      </template>
    </v-snackbar>
  </v-row>
</template>

<script>
export default {
  name: "IndexPage",
  mounted() {
    this.listPosts();
  },
  data() {
    return {
      toast: false,
      toastMensagem: "",
      searchOptions: {
        search: "",
        blog: "",
      },
      posts: [],
      page: 0,
      hasMore: true,
    };
  },

  methods: {
    listPosts(page = 0) {
      let url = `/post?page=${page}`;

      if (this.searchOptions.search) {
        url += `&search=${this.searchOptions.search}`;
      }

      this.$axios
        .$get(url)
        .then((response) => {
          if (page != 0) {
            this.posts = this.posts.concat(response);
          } else {
            this.posts = response;
          }
          this.hasMore = response.length == 30;
        })
        .catch((error) => {
          //console.log(error);
          this.displayToast(
            "Resposta inseperada do servidor, recarregue a pagina e tente novamente."
          );
        });
    },

    async referSite(post) {
      try {
        let thumbnail = post.thumbnail;
        post.thumbnail = "https://devall.com.br/assets/volte_logo.png";
        const response = await this.$axios.$get(`/post/clique/${post.id}`);
        post.cliques = response.cliques;
        window.open(response.url, "blank");
        post.thumbnail = thumbnail;
      } catch (error) {
        this.displayToast(
          "Resposta inseperada do servidor, recarregue a pagina e tente novamente."
        );
      }
    },

    displayToast(mensagem) {
      this.toastMensagem = mensagem;
      this.toast = true;
    },
  },
};
</script>

<style lang="sass" scoped>
.v-card.on-hover.theme--dark
  background-color: #3f51b5
  >.v-card__text
    color: #000
</style>
