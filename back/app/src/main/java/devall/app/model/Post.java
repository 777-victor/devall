package devall.app.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "blog_post")
public class Post{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 200)
    private String resumo;
    @Column(nullable = false, length = 128)
    private String titulo;
    @Column(nullable = false)
    private Integer cliques = 0;
    @Column(name = "data_inclusao", nullable = false)
    private Date dataInclusao;
    @Column(name = "data_publicacao", nullable = false)
    private Date dataPublicacao;
    @Column(name = "votos_positivos", nullable = false)
    private Integer votosPositivos;
    @Column(name = "votos_negativos", nullable = false)
    private Integer votosNegativos;
    private Long favoritos = 0l, comentarios = 0l;
    @Column(nullable = false, length = 1024)
    private String url;

    @ManyToOne
    @JoinColumn(name="site_id", nullable=false)
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

    public Date getDataInclusao() {
        return this.dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Date getDataPublicacao() {
        return this.dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Integer getVotosPositivos() {
        return this.votosPositivos;
    }

    public void setVotosPositivos(Integer votosPositivos) {
        this.votosPositivos = votosPositivos;
    }

    public Integer getVotosNegativos() {
        return this.votosNegativos;
    }

    public void setVotosNegativos(Integer votosNegativos) {
        this.votosNegativos = votosNegativos;
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
        return this.blog;
    }

    public void setBlog(Site blog) {
        this.blog = blog;
    }

}


