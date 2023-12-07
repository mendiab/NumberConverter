package de.menouer.numberconverter.service.convesiontype.impl;

import org.springframework.stereotype.Service;
import de.menouer.numberconverter.model.NumeralsConversionType;
import de.menouer.numberconverter.service.convesiontype.NumeralConversionTypeService;

@Service
public class NumeralConversionTypeServiceImpl implements NumeralConversionTypeService {

    @Override
    public NumeralsConversionType[] getConversionTypes() {
        return NumeralsConversionType.values();
    }

}
