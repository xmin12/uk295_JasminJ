package ch.noseryoung.supplier_295.domain.authority;

import org.springframework.stereotype.Service;

@Service
public class AuthorityService {
    private final AuthorityRepository authorityRepository;

    public AuthorityService(AuthorityRepository authorityRepository){
        this.authorityRepository = authorityRepository;
    }
}
