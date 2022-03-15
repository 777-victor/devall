package devall.app.dto;

import com.fasterxml.jackson.annotation.JsonFilter;

import devall.app.model.Post;
import devall.app.model.Site;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    private Long id;

    private String resumo;

    private String titulo;

    private Integer cliques;

    private String dataInclusao;

    private String dataPublicacao;

    private Integer votosNegativos;

    private Integer votosPositivos;

    private Long favoritos;

    private Long comentarios;

    private String url;

    private Site blog;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResumo() {
        return this.resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getCliques() {
        return this.cliques;
    }

    public void setCliques(Integer cliques) {
        this.cliques = cliques;
    }

    public String getDataInclusao() {
        return this.dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        dateFormat.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
        this.dataInclusao = dateFormat.format(dataInclusao);
    }

    public String getDataPublicacao() {
        return this.dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        dateFormat.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
        this.dataPublicacao = dateFormat.format(dataPublicacao);
    }

    public Integer getVotosNegativos() {
        return this.votosNegativos;
    }

    public void setVotosNegativos(Integer votosNegativos) {
        this.votosNegativos = votosNegativos;
    }

    public Integer getVotosPositivos() {
        return this.votosPositivos;
    }

    public void setVotosPositivos(Integer votosPositivos) {
        this.votosPositivos = votosPositivos;
    }

    public Long getFavoritos() {
        return this.favoritos;
    }

    public void setFavoritos(Long favoritos) {
        this.favoritos = favoritos;
    }

    public Long getComentarios() {
        return this.comentarios;
    }

    public void setComentarios(Long comentarios) {
        this.comentarios = comentarios;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Site getBlog() {
        return blog;
    }

    public void setBlog(Site blog) {
        this.blog = blog;
    }
}
