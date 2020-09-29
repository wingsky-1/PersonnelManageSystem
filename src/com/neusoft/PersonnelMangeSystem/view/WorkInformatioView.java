package com.neusoft.PersonnelMangeSystem.view;

import com.neusoft.PersonnelMangeSystem.util.ViewPrints;
import com.neusoft.PersonnelMangeSystem.util.ViewScanners;

/**
 * @author 火羽白
 * @date 2020/9/28
 */
public class WorkInformatioView {
    public WorkInformatioView(){
        init();
    }

    private void init() {
        ViewPrints.printError(ViewPrints.UNDEVELOPED_ERROR);
        ViewScanners.nextString();
        ViewPrints.back();
    }
}
