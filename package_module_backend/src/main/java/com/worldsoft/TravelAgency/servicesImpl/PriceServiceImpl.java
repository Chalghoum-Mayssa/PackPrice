package com.worldsoft.TravelAgency.servicesImpl;


import com.worldsoft.TravelAgency.Exceptions.ResourceNotFoundException;
import com.worldsoft.TravelAgency.Exceptions.ServiceException;
import com.worldsoft.TravelAgency.entities.PrmPricePacktype;
import com.worldsoft.TravelAgency.entities.PrmPricePacktypeId;
import com.worldsoft.TravelAgency.repositories.PriceRepos;
import com.worldsoft.TravelAgency.services.ServicePrice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Service
public class PriceServiceImpl implements ServicePrice {

    @Autowired
    private PriceRepos priceRepos;

    @Override
    public List<PrmPricePacktype> getAllPack() {
        try {
            return priceRepos.findAll();
        } catch (Exception e) {
            throw new ServiceException("Error fetching all packs", e);
        }
    }

    @Override
    public Optional<PrmPricePacktype> findById(PrmPricePacktypeId id) {
        try {
            return priceRepos.findById(id);
        } catch (Exception e) {
            throw new ServiceException("Error fetching pack by id", e);
        }
    }

    @Override
    public Optional<PrmPricePacktype> findByIdTypepack(long idTypepack) {
        try {
            Optional<PrmPricePacktype> pack = priceRepos.findByIdTypepack(idTypepack);
            if (pack.isPresent()) {
                return pack;
            } else {
                throw new ResourceNotFoundException("Pack not found with type id: " + idTypepack);
            }
        } catch (ResourceNotFoundException e) {
            throw e; // rethrow the specific exception
        } catch (Exception e) {
            throw new ServiceException("Error fetching pack by type id", e);
        }
    }

    @Override
    public PrmPricePacktype save(PrmPricePacktype packprice) {
        try {
            if (packprice.getId() == null) {
                PrmPricePacktypeId newId = new PrmPricePacktypeId();
                newId.setIdEntite(1L); // Set idEntite to 1
                BigDecimal maxIdTypepack = priceRepos.getMaxIdPricepack();
                if (maxIdTypepack == null) {
                    maxIdTypepack = BigDecimal.ONE;
                } else {
                    maxIdTypepack = maxIdTypepack.add(BigDecimal.ONE); // Increment idTypepack
                }
                newId.setIdTypepack(maxIdTypepack.longValue());
                packprice.setId(newId);
            }
            return priceRepos.save(packprice);
        } catch (Exception e) {
            throw new ServiceException("Error saving pack", e);
        }
    }

    @Override
    public void deleteById(PrmPricePacktypeId id) {
        try {
            priceRepos.deleteById(id);
        } catch (Exception e) {
            throw new ServiceException("Error deleting pack by id", e);
        }
    }

    @Override
    public PrmPricePacktype update(PrmPricePacktype packprice) {
        try {
            return priceRepos.save(packprice);
        } catch (Exception e) {
            throw new ServiceException("Error updating pack", e);
        }
    }

    @Override
    public List<PrmPricePacktype> findByTypepackNameLike(String typepackName) {
        try {
            return priceRepos.findByTypepackNameLike(typepackName);
        } catch (Exception e) {
            throw new ServiceException("Error fetching pack by name", e);
        }
    }

}

