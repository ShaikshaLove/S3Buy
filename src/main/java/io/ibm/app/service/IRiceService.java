package io.ibm.app.service;

import io.ibm.app.model.Rice;

public interface IRiceService {
    int saveRice(Rice rice);
    Rice getRice();
}
