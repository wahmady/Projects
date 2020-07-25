import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.RandomAccess;

/**
 * This class provides all code necessary to take a query box and produce
 * a query result. The getMapRaster method must return a Map containing all
 * seven of the required fields, otherwise the front end code will probably
 * not draw the output correctly.
 */
public class Rasterer {
    /**
     * The max image depth level.
     */
    public static final int MAX_DEPTH = 7;
    public ArrayList<Double> depthdict = new ArrayList<>();

    /**
     * Takes a user query and finds the grid of images that best matches the query. These images
     * will be combined into one big image (rastered) by the front end. The grid of images must obey
     * the following properties, where image in the grid is referred to as a "tile".
     * <ul>
     * <li>The tiles collected must cover the most longitudinal distance per pixel (LonDPP)
     * possible, while still covering less than or equal to the amount of longitudinal distance
     * per pixel in the query box for the user viewport size.</li>
     * <li>Contains all tiles that intersect the query bounding box that fulfill the above
     * condition.</li>
     * <li>The tiles must be arranged in-order to reconstruct the full image.</li>
     * </ul>
     *
     * @param params The RasterRequestParams containing coordinates of the query box and the browser
     *               viewport width and height.
     * @return A valid RasterResultParams containing the computed results.
     */
    //RasterResultParams//
    public RasterResultParams getMapRaster(RasterRequestParams params) {
        System.out.println("Since you haven't implemented getMapRaster, nothing is displayed in the browser.");
        boolean querrysuccess = true;

        /* TODO: Make sure you can explain every part of the task before you begin.
         * Hint: Define additional classes to make it easier to pass around multiple values, and
         * define additional methods to make it easier to test and reason about code. */
        if (params.lrlat > MapServer.ROOT_ULLAT || params.ullat < MapServer.ROOT_LRLAT ||
                params.lrlon < MapServer.ROOT_ULLON || params.ullon > MapServer.ROOT_LRLON) {
           // querrysuccess = false;
            return RasterResultParams.queryFailed();
        }
        double querryDPP = lonDPP(params.lrlon, params.ullon, params.w);
        int depth = depthChooser(querryDPP);
        System.out.println(querryDPP + " and this is the depth "   + depth);

        String[][] rendergrid = stringarray(coords(params, depth), depth);
        double[] latlon = buildercoords(params, depth);
        double b_ullat = latlon[0];
        double b_ullon = latlon[1];
        double b_lrlat = latlon[2];
        double b_lrlon = latlon[3];

        RasterResultParams.Builder build = new RasterResultParams.Builder();
        build.setRenderGrid(rendergrid);
        build.setRasterUlLat(b_ullat);
        build.setRasterUlLon(b_ullon);
        build.setRasterLrLat(b_lrlat);
        build.setRasterLrLon(b_lrlon);
        build.setQuerySuccess(querrysuccess);
        build.setDepth(depth);
        RasterResultParams rasta = build.create();
        return rasta;
    }

    public String[][] stringarray(int[] coords, int depth) {
        int xstart = coords[2];
        int xend = coords[3];
        int ystart = coords[0];
        int yend = coords[1];

        System.out.println(xstart + " " + xend + " " + ystart + " " + yend);
        String[][] rtrnArray = new String[yend - ystart + 1][xend - xstart + 1];

        for (int y = ystart, i = 0; y <= yend; y++, i++) {
            for (int x = xstart, k = 0; x <= xend ; x++, k++) {
                rtrnArray[i][k] = "d" + Integer.toString(depth) + "_x" + x + "_y" + y +
                        ".png";
            }
        }
        return rtrnArray;
    }

    public int[] coords(RasterRequestParams params, int depth){
        System.out.println("Depth is" + " " + depth);
        int cpydepth = depth;
        if(depth > 7){
            depth = 7;
        }
        double boxes = Math.pow(2, depth);
        double ullon = MapServer.ROOT_ULLON;
        double lrlon = MapServer.ROOT_LRLON;
        double ullat = MapServer.ROOT_ULLAT;
        double lrlat = MapServer.ROOT_LRLAT;
        double p_ullon = params.ullon;
        double p_lrlon = params.lrlon;
        double p_ullat = params.ullat;
        double p_lrlat = params.lrlat;
        if(p_ullon < ullon) {
            p_ullon = ullon;
        }
        if (p_ullat > ullat) {
            p_ullat = ullat;
        }
        if (p_lrlat < lrlat){
            p_lrlat = lrlat;
        }
        if(p_lrlon > lrlon){
            p_lrlon = lrlon;
        }

        int x1 = (int) Math.floor(((ullat - p_ullat)/(ullat - lrlat)) * boxes);
        int x2 = (int) Math.floor(((ullat - p_lrlat)/(ullat - lrlat)) * boxes);
        int y1 = (int) Math.floor(((ullon - p_ullon)/(ullon - lrlon)) * boxes);
        int y2 = (int) Math.floor(((ullon - p_lrlon)/(ullon - lrlon)) * boxes);

        System.out.println(x1 + " " + x2 + " " + y1 + " " + y2);

//        int y1 = (int) Math.floor(((-1)*((ullon - p_ullon))/(MapServer.ROOT_LON_DELTA)) * boxes);
//        int y2 = (int) Math.floor(((-1)*(ullon - p_lrlon)/(MapServer.ROOT_LON_DELTA)) * boxes);
//        int x1 = (int) Math.floor(((ullat - p_ullat)/( MapServer.ROOT_LAT_DELTA)) * boxes);
//        int x2 = (int) Math.floor(((ullat - p_lrlat)/(MapServer.ROOT_LAT_DELTA)) * boxes);

        int[] coords = {x1,x2,y1,y2};
        return coords;
    }
    public double[] buildercoords(RasterRequestParams params, int depth) {
        double boxes = Math.pow(2, depth);
        double ullon = MapServer.ROOT_ULLON;
        double lrlon = MapServer.ROOT_LRLON;
        double ullat = MapServer.ROOT_ULLAT;
        double lrlat = MapServer.ROOT_LRLAT;
        double p_ullon = params.ullon;
        double p_lrlon = params.lrlon;
        double p_ullat = params.ullat;
        double p_lrlat = params.lrlat;
        if (p_ullon < ullon) {
            p_ullon = ullon;
        }
        if (p_ullat > ullat) {
            p_ullat = ullat;
        }
        if (p_lrlat < lrlat) {
            p_lrlat = lrlat;
        }
        if (p_lrlon > lrlon) {
            p_lrlon = lrlon;
        }
        int y1 = (int) Math.floor(((ullon - p_ullon) / (ullon - lrlon)) * boxes);
        int x1 = (int) Math.floor(((ullat - p_ullat) / (ullat - lrlat)) * boxes);
//change
        int x2 = (int) Math.floor(((p_lrlat - lrlat) / (MapServer.ROOT_LAT_DELTA)) * boxes);
        int y2 = (int) Math.floor(((lrlon - p_lrlon) / (MapServer.ROOT_LON_DELTA)) * boxes);

        //System.out.println(x1 + " " + x2 + " " + y1 + " " + y2);
       double r1 = x1 / boxes;
       double r2 = x2 / boxes;
       double r3 = y1 / boxes;
       double r4 = y2 / boxes;

       System.out.println(r1 + " " + r2 + " " + r4);


        double bullat = ullat - (r1 * MapServer.ROOT_LAT_DELTA);
        double bullon = ullon + (r3 * MapServer.ROOT_LON_DELTA);
        double bllat = lrlat + (r2 * MapServer.ROOT_LAT_DELTA);
        double bllon = lrlon - (r4 * MapServer.ROOT_LON_DELTA);

        System.out.println(bllon + " " + (r4 * MapServer.ROOT_LON_DELTA));

        double[] bcoords = {bullat, bullon, bllat, bllon};
        //System.out.println(MapServer.ROOT_LAT_DELTA);
        //System.out.println(MapServer.ROOT_LON_DELTA);
       // System.out.println(bullat + " " + bullon);
        return  bcoords;
    }

    /**
     * Calculates the lonDPP of an image or query box
     * @param lrlon Lower right longitudinal value of the image or query box
     * @param ullon Upper left longitudinal value of the image or query box
     * @param width Width of the query box or image
     * @return lonDPP
     */




    private double lonDPP(double lrlon, double ullon, double width) {
        return (lrlon - ullon) / width;
    }

    private int depthChooser(double querrydpp) {
        int depthvalue = 0;
        double d0dpp = MapServer.ROOT_LONDPP;


        for (int i = 1; i <= MAX_DEPTH; i++) {
            depthdict.add(d0dpp / Math.pow(2, i-1));
        }
        System.out.println(MAX_DEPTH);
        if (querrydpp < depthdict.get(depthdict.size() - 1)) {
            return 7;
        } else {
            for (int i = 0; i < depthdict.size(); i++) {
                depthvalue = i;
                if (depthdict.get(i) < querrydpp) {
                    return depthvalue;
                }
            }
        }
        return 7;
    }

//    public static void main(String[] args) {
//        RasterRequestParams.Builder testbuilder = new RasterRequestParams.Builder();
//        testbuilder.setH(875.0);
//        testbuilder.setW(892.0);
//        testbuilder.setUllat(37.87655);
//        testbuilder.setUllon(-122.241632);
//        testbuilder.setLrlat(37.87548);
//        testbuilder.setLrlon(-122.24053);
//        RasterRequestParams testparams = testbuilder.create();
//        Rasterer testraster = new Rasterer();
//        testraster.getMapRaster(testparams);
//
//    }

}

/*
Start the formulas for the query box to get the images
then return a 2D array of the images using a for loop.
 */