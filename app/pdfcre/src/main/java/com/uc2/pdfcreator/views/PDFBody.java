package com.uc2.pdfcreator.views;

import com.uc2.pdfcreator.views.basic.PDFView;

import java.io.Serializable;
import java.util.ArrayList;

public class PDFBody implements Serializable {

    private final ArrayList<PDFView> childViewList = new ArrayList<>();

    public PDFBody() {
    }

    public PDFBody addView(PDFView pdfViewToAdd) {
        if (pdfViewToAdd instanceof PDFTableView) {
            childViewList.addAll(pdfViewToAdd.getChildViewList());
        } else {
            childViewList.add(pdfViewToAdd);
        }
        return this;
    }

    public ArrayList<PDFView> getChildViewList() {
        return childViewList;
    }
}
