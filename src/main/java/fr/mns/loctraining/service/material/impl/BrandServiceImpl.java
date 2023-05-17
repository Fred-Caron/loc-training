package fr.mns.loctraining.service.material.impl;

import fr.mns.loctraining.domain.model.material.Brand;
import fr.mns.loctraining.domain.repository.material.BrandRepository;

import fr.mns.loctraining.service.material.BrandService;
import fr.mns.loctraining.tools.exception.BadRequestException;
import fr.mns.loctraining.tools.exception.NotFoundException;
import fr.mns.loctraining.vo.material.brand.BrandCreateRequest;
import fr.mns.loctraining.vo.material.brand.BrandDetails;
import fr.mns.loctraining.vo.material.brand.BrandUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    @Override
    public BrandDetails getDetails(Integer id) {
        Brand brand = brandRepository.findByIdNullSafe(id);
        if(brand == null){
            throw new NotFoundException();
        }
        return getDetails(brand);
    }

    @Override
    public List<BrandDetails> getList() {
        List<Brand> brandList = brandRepository.findAll();
        List<BrandDetails> brandDetailsList = new ArrayList<>();
        for (Brand brand : brandList) {
            BrandDetails details = getDetails(brand);
            brandDetailsList.add(details);
        }
        return brandDetailsList;
    }

    @Override
    public BrandDetails create(BrandCreateRequest request) {
       if(!StringUtils.hasText(request.getName())){
           throw new BadRequestException("Name should not be empty");
       }
       Brand brand = new Brand();
       brand.setName(request.getName());
       brand = brandRepository.save(brand);
       return getDetails(brand);
    }

    @Override
    public BrandDetails update(Integer id, BrandUpdateRequest request) {
        Brand brand = brandRepository.findByIdNullSafe(id);
        if(brand == null){
            throw new NotFoundException();
        }
        if(!StringUtils.hasText(request.getName())){
            throw new BadRequestException("Name should not be empty");
        }
        brand.setName(request.getName());
        brand = brandRepository.save(brand);
        return getDetails(brand);
    }

    @Override
    public void delete(Integer id) {
        Brand brand = brandRepository.findByIdNullSafe(id);
        if(brand == null){
            throw new NotFoundException();
        }
        brandRepository.delete(brand);
    }

    private BrandDetails getDetails(Brand brand){
        BrandDetails details = new BrandDetails();
        details.setId(brand.getId());
        details.setName(brand.getName());
        return details;
    }
}
