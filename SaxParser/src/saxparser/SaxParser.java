/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saxparser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author mani
 */
public class SaxParser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SaxParser parser = new SaxParser();
        parser.parseXML();
    }

    public void parseXML() {
        try {
            ///home/mani/NetBeansProjects/SaxParser/lib/Param.xml
            File fil = new File(System.getProperty("user.dir")
                    + File.separator + "lib" + File.separator + "Param.xml");

            System.out.println("fil > " + fil.getAbsolutePath());
            SAXParserFactory saxFact = SAXParserFactory.newInstance();
            SAXParser parser = saxFact.newSAXParser();
            SAXHandler hander = new SAXHandler();
            parser.parse(fil, hander);

            System.out.println("hander.getMapTst() > " + hander.getMapTst());

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(SaxParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(SaxParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SaxParser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private class SAXHandler extends DefaultHandler {

        Map<String, TestParam> mapTst = new HashMap();
        Map<Float, BandWidth> mapBand = new HashMap();
        Map<Integer, NRB> mapNRB = new HashMap();
        Map<String, RBP> mapRBP = new HashMap();
        List<FieldParam> listFields = new ArrayList();

        TestParam tstParam;
        BandWidth bndWidth;
        NRB nrb;
        RBP rbp;
        FieldParam fieldParam;

        String testName;
        String rbpVal;

        int nrbVal;
        float bandWidVal;

        public Map<String, TestParam> getMapTst() {
            return mapTst;
        }

        /**
         * Receive notification of the start of an element.
         *
         * <p>
         * By default, do nothing. Application writers may override this method
         * in a subclass to take specific actions at the start of each element
         * (such as allocating a new tree node or writing output to a file).</p>
         *
         * @param uri The Namespace URI, or the empty string if the element has
         * no Namespace URI or if Namespace processing is not being performed.
         * @param localName The local name (without prefix), or the empty string
         * if Namespace processing is not being performed.
         * @param qName The qualified name (with prefix), or the empty string if
         * qualified names are not available.
         * @param attributes The attributes attached to the element. If there
         * are no attributes, it shall be an empty Attributes object.
         * @exception org.xml.sax.SAXException Any SAX exception, possibly
         * wrapping another exception.
         * @see org.xml.sax.ContentHandler#startElement
         */
        public void startElement(String uri, String localName,
                String qName, Attributes attributes)
                throws SAXException {
            switch (qName) {
                case "TEST":
                    tstParam = new TestParam();
                    testName = attributes.getValue("name");
                    tstParam.setTestName(testName);
                    break;
                case "BANDWIDTH":
                    bndWidth = new BandWidth();
                    bandWidVal = Float.parseFloat(attributes.getValue("value"));
                    bndWidth.setBandWidth(bandWidVal);
                    break;
                case "NRB":
                    mapRBP = new HashMap();
                    nrb = new NRB();
                    nrb.setIdx(Integer.parseInt(attributes.getValue("idx")));
                    nrbVal = Integer.parseInt(attributes.getValue("value"));
                    nrb.setValue(nrbVal);
                    break;
                case "RBP":
                    listFields = new ArrayList();
                    rbp = new RBP();
                    rbp.setIdx(Integer.parseInt(attributes.getValue("idx")));
                    rbpVal = attributes.getValue("value");
                    rbp.setValue(rbpVal);
                    break;
                case "FIELD":
                    fieldParam = new FieldParam();
                    fieldParam.setKey(attributes.getValue("name"));
                    fieldParam.setValue(attributes.getValue("value"));
                    break;
                default:
                    break;

            }
        }

        /**
         * Receive notification of the end of an element.
         *
         * <p>
         * By default, do nothing. Application writers may override this method
         * in a subclass to take specific actions at the end of each element
         * (such as finalising a tree node or writing output to a file).</p>
         *
         * @param uri The Namespace URI, or the empty string if the element has
         * no Namespace URI or if Namespace processing is not being performed.
         * @param localName The local name (without prefix), or the empty string
         * if Namespace processing is not being performed.
         * @param qName The qualified name (with prefix), or the empty string if
         * qualified names are not available.
         * @exception org.xml.sax.SAXException Any SAX exception, possibly
         * wrapping another exception.
         * @see org.xml.sax.ContentHandler#endElement
         */
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            switch (qName) {
                case "TEST":
                    tstParam.setMapTestParam(mapBand);
                    mapTst.put(testName, tstParam);
                    break;
                case "BANDWIDTH":
                    bndWidth.setMapNRB(mapNRB);
                    mapBand.put(bandWidVal, bndWidth);
                    break;
                case "NRB":
                    nrb.setMapRBP(mapRBP);
                    mapNRB.put(nrbVal, nrb);
                    break;
                case "RBP":
                    rbp.setLstField(listFields);
                    mapRBP.put(rbpVal, rbp);
                    break;
                case "FIELD":
                    listFields.add(fieldParam);
                    break;
                default:
                    break;

            }
        }

        /**
         * Receive notification of character data inside an element.
         *
         * <p>
         * By default, do nothing. Application writers may override this method
         * to take specific actions for each chunk of character data (such as
         * adding the data to a node or buffer, or printing it to a file).</p>
         *
         * @param ch The characters.
         * @param start The start position in the character array.
         * @param length The number of characters to use from the character
         * array.
         * @exception org.xml.sax.SAXException Any SAX exception, possibly
         * wrapping another exception.
         * @see org.xml.sax.ContentHandler#characters
         */
        public void characters(char ch[], int start, int length)
                throws SAXException {

        }

    }

}
