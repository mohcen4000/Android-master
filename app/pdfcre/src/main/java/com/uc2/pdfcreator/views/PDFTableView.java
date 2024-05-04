package com.uc2.pdfcreator.views;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.uc2.pdfcreator.views.basic.PDFHorizontalView;
import com.uc2.pdfcreator.views.basic.PDFLineSeparatorView;
import com.uc2.pdfcreator.views.basic.PDFTextView;
import com.uc2.pdfcreator.views.basic.PDFVerticalView;
import com.uc2.pdfcreator.views.basic.PDFView;

import java.io.Serializable;

public class PDFTableView extends PDFView implements Serializable {

    public PDFTableView(Context context, PDFTableRowView headerRow, PDFTableRowView firstRow) {
        super(context);
        PDFVerticalView verticalView = new PDFVerticalView(context);
        verticalView.addView(headerRow);
        verticalView.addView(new PDFLineSeparatorView(context).setBackgroundColor(Color.BLACK));
        verticalView.addView(firstRow);
        super.addView(verticalView);
    }

    @Deprecated
    @Override
    public PDFTableView addView(PDFView viewToAdd) throws IllegalStateException {
        throw new IllegalStateException("Add a row or column to add view");
    }

    public PDFTableView addRow(PDFTableRowView rowView) {
        super.addView(rowView);
        return this;
    }

    public PDFTableView addSeparatorRow(PDFLineSeparatorView separatorView) {
        super.addView(separatorView);
        return this;
    }

    @Override
    public PDFView setLayout(ViewGroup.LayoutParams layoutParams) {
        return super.setLayout(layoutParams);
    }

    public static class PDFTableRowView extends PDFHorizontalView implements Serializable {

        public PDFTableRowView(Context context) {
            super(context);
        }

        /**
         * Does some thing in old style.
         *
         * @deprecated use {PDFTableRowView.addToRow()} instead.
         */
        @Deprecated
        @Override
        public PDFHorizontalView addView(PDFView viewToAdd) {
            throw new IllegalStateException("Cannot add subview to Horizontal View, Use createRow instead");
        }


        public PDFTableRowView addToRow(PDFTextView TextViewToAdd) {
            TextViewToAdd.setLayout(new LinearLayout.LayoutParams(
                    0,
                    ViewGroup.LayoutParams.WRAP_CONTENT, 1));
            super.addView(TextViewToAdd);

            return this;
        }
    }
}
