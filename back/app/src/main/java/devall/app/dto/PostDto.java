package devall.app.dto;


import com.fasterxml.jackson.annotation.JsonFilter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@JsonFilter("myFilter")
public class PostDto {
    //private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    // public Date getDataInclusaoConverted(String timezone) throws ParseException {
    //     dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
    //     return dateFormat.parse(this.dataInclusao);
    // }

    // public Date getDataInclusaoConverted(String timezone) throws ParseException {
    //     dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
    //     return dateFormat.parse(this.dataInclusao);
    // }

    private Long id;

    private String resumo;

    private String titulo;

    private Integer cliques = 0;

    private String dataInclusao;

    private String dataPublicacao;

    private Integer votosNegativos;

    private Integer votosPositivos;

    private Long favoritos = 0l, comentarios = 0l;

    private String url;

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

    public void setDataInclusao(String dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public String getDataPublicacao() {
        return this.dataPublicacao;
    }

    public void setDataPublicacao(String dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
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

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
