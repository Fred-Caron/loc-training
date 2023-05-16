package fr.mns.loctraining.service.materialImpl;

import fr.mns.loctraining.domain.repository.material.BrandRepository;
import fr.mns.loctraining.service.BrandService;
import fr.mns.loctraining.vo.material.brand.BrandCreateRequest;
import fr.mns.loctraining.vo.material.brand.BrandDetails;
import fr.mns.loctraining.vo.material.brand.BrandUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    @Override
    public BrandDetails getDetails(Integer id) {
        return null;
    }

    @Override
    public List<BrandDetails> getList() {
        return null;
    }

    @Override
    public BrandDetails create(BrandCreateRequest request) {
        return null;
    }

    @Override
    public BrandDetails update(Integer id, BrandUpdateRequest request) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
