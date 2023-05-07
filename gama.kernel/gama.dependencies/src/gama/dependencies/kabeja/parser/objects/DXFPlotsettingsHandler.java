/*******************************************************************************************************
 *
 * DXFPlotsettingsHandler.java, in gama.dependencies, is part of the source code of the
 * GAMA modeling and simulation platform (v.2.0.0).
 *
 * (c) 2007-2023 UMI 209 UMMISCO IRD/SU & Partners (IRIT, MIAT, TLU, CTU)
 *
 * Visit https://github.com/gama-platform/gama2 for license information and contacts.
 * 
 ********************************************************************************************************/
package gama.dependencies.kabeja.parser.objects;

import gama.dependencies.kabeja.dxf.DXFConstants;
import gama.dependencies.kabeja.dxf.objects.DXFObject;
import gama.dependencies.kabeja.dxf.objects.DXFPlotSettings;
import gama.dependencies.kabeja.parser.DXFValue;


public class DXFPlotsettingsHandler extends AbstractDXFObjectHandler {
    public final static int GROUPCODE_NAME = 1;
    public final static int GROUPCODE_PLOT_CONFIGURATION_FILE = 2;
    public final static int GROUPCODE_PAPER_SIZE = 4;
    public final static int GROUPCODE_PLOT_VIEW_NAME = 6;
    public final static int GROUPCODE_MARGIN_LEFT = 40;
    public final static int GROUPCODE_MARGIN_BOTTOM = 41;
    public final static int GROUPCODE_MARGIN_RIGHT = 42;
    public final static int GROUPCODE_MARGIN_TOP = 43;
    public final static int GROUPCODE_PLOT_PAPER_WIDTH = 44;
    public final static int GROUPCODE_PLOT_PAPER_HEIGHT = 45;
    public final static int GROUPCODE_ORIGIN_X = 46;
    public final static int GROUPCODE_ORIGIN_Y = 47;
    public final static int GROUPCODE_PLOT_WINDOW_MIN_X = 48;
    public final static int GROUPCODE_PLOT_WINDOWS_MIN_Y = 49;
    public final static int GROUPCODE_PLOT_WINDOW_MAX_X = 140;
    public final static int GROUPCODE_PLOT_WINDOWS_MAX_Y = 141;
    public final static int GROUPCODE_CUSTOM_SCALE_NUMERATOR = 142;
    public final static int GROUPCODE_CUSTOM_SCALE_DEOMINATOR = 143;
    public final static int GROUPCODE_PAPER_UNITS = 72;
    public final static int GROUPCODE_PLOT_ROTATION = 73;
    public final static int GROUPCODE_PLOT_TYPE = 74;
    public final static int GROUPCODE_CURRENT_STYLESHEET = 7;
    public final static int GROUPCODE_STANDARD_SCALE_TYPE = 75;
    protected DXFPlotSettings plotSettings;

    public void endObject() {
    }

    public DXFObject getDXFObject() {
        return this.plotSettings;
    }

    public String getObjectType() {
        return DXFConstants.OBJECT_TYPE_PLOTSETTINGS;
    }

    public void parseGroup(int groupCode, DXFValue value) {
        double[] m;

        switch (groupCode) {
        case GROUPCODE_CURRENT_STYLESHEET:
            this.plotSettings.setCurrentStylesheet(value.getValue());

            break;

        case GROUPCODE_CUSTOM_SCALE_DEOMINATOR:
            this.plotSettings.setCustomScaleDenominator(value.getDoubleValue());

            break;

        case GROUPCODE_CUSTOM_SCALE_NUMERATOR:
            this.plotSettings.setCustomScaleNumerator(value.getDoubleValue());

            break;

        case GROUPCODE_MARGIN_BOTTOM:
            m = this.plotSettings.getMargin();
            m[2] = value.getDoubleValue();
            this.plotSettings.setMargin(m);

            break;

        case GROUPCODE_MARGIN_LEFT:
            m = this.plotSettings.getMargin();
            m[3] = value.getDoubleValue();
            this.plotSettings.setMargin(m);

            break;

        case GROUPCODE_MARGIN_RIGHT:
            m = this.plotSettings.getMargin();
            m[1] = value.getDoubleValue();
            this.plotSettings.setMargin(m);

            break;

        case GROUPCODE_MARGIN_TOP:
            m = this.plotSettings.getMargin();
            m[0] = value.getDoubleValue();
            this.plotSettings.setMargin(m);

            break;

        case GROUPCODE_ORIGIN_X:
            this.plotSettings.getPlotOrigin().setX(value.getDoubleValue());

            break;

        case GROUPCODE_ORIGIN_Y:
            this.plotSettings.getPlotOrigin().setY(value.getDoubleValue());

            break;

        case GROUPCODE_NAME:
            this.plotSettings.setName(value.getValue());

            break;

        case GROUPCODE_PAPER_SIZE:

            //this.plotSettings.
            break;

        case GROUPCODE_PAPER_UNITS:
            this.plotSettings.setPaperUnit(value.getIntegerValue());

            break;

        case GROUPCODE_PLOT_CONFIGURATION_FILE:
            break;

        case GROUPCODE_PLOT_PAPER_HEIGHT:
            this.plotSettings.setPaperHeight(value.getDoubleValue());

            break;

        case GROUPCODE_PLOT_PAPER_WIDTH:
            this.plotSettings.setPaperWidth(value.getDoubleValue());

            break;

        case GROUPCODE_PLOT_ROTATION:
            this.plotSettings.setPlotRotation(value.getIntegerValue());

            break;

        case GROUPCODE_PLOT_TYPE:
            this.plotSettings.setPlotType(value.getIntegerValue());

            break;

        case GROUPCODE_PLOT_VIEW_NAME:
            this.plotSettings.setPlotViewName(value.getValue());

            break;

        case GROUPCODE_PLOT_WINDOW_MAX_X:
            this.plotSettings.getWindowToPlot()
                             .setMaximumX(value.getDoubleValue());

            break;

        case GROUPCODE_PLOT_WINDOW_MIN_X:
            this.plotSettings.getWindowToPlot()
                             .setMinimumX(value.getDoubleValue());

            break;

        case GROUPCODE_PLOT_WINDOWS_MAX_Y:
            this.plotSettings.getWindowToPlot()
                             .setMaximumY(value.getDoubleValue());

            break;

        case GROUPCODE_PLOT_WINDOWS_MIN_Y:
            this.plotSettings.getWindowToPlot()
                             .setMinimumY(value.getDoubleValue());

            break;

        default:
            super.parseCommonGroupCode(groupCode, value, this.plotSettings);
        }
    }

    public void startObject() {
        this.plotSettings = new DXFPlotSettings();
    }
}
