package devall.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import devall.app.model.Site;

public interface SiteRepository extends JpaRepository<Site, Long> {
    
}
