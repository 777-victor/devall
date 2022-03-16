# devall

## Front
Optei por utilizar o nuxt ( framework para vue ) para criar o projeto e o vuetify para desenvolver as páginas,
como eu já estou familiarizado com essas tecnologias não tiver problemas no desenvolver do frontend. O único obstáculo foi implementar
a paginação que estava oculta na documentação e não é retornado na resposa.
---

## Back

Utilizei Spring e apesar de não ter tanta prática não tive problemas em desenvolver esses endpoints. O que eu tive mais
dúvidas foi na hora de ocultar a url porque ao pesquisar eu encontrei pessoas utilizando o MappingJackson com o @JsonFilter 
para ocultar dinamicamente um campo no json. Mas como eu já estava chamando o stream().map() na conversão para DTO eu decidi 
simplesmente chamar o post.setUrl(null) durante este map que converte para DTO para não precisar chamar o MappingJackson e
diminuir o desempenho da função adicionando outro map. Também decidi complementar o endpoint /post com o retorno de dados
úteis para paginação que fizeram falta no desenvolver do front-end. 
