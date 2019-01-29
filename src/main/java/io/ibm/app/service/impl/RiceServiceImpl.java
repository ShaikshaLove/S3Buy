package io.ibm.app.service.impl;
import io.ibm.app.model.Rice;
import io.ibm.app.repository.RiceRepository;
import io.ibm.app.service.IRiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RiceServiceImpl implements IRiceService {

    @Autowired
    private RiceRepository repo;
    @Override
    public int saveRice(Rice rice) {
        return repo.save(rice).getRiceId();
    }

    @Override
    public Rice getRice() {
        return null;
    }
}
