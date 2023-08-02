



public class WriteXmlDom {

    public static void main(String[] args)
            throws ParserConfigurationException, TransformerException {

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("company");
        doc.appendChild(rootElement);

        

        
        Element staff = doc.createElement("staff");
        
        rootElement.appendChild(staff);
        
        staff.setAttribute("id", "1001");

        
        
        
        

        Element name = doc.createElement("name");
        
        
        
        name.setTextContent("mkyong");
        staff.appendChild(name);

        Element role = doc.createElement("role");
        role.setTextContent("support");
        staff.appendChild(role);

        Element salary = doc.createElement("salary");
        salary.setAttribute("currency", "USD");
        salary.setTextContent("5000");
        staff.appendChild(salary);

        
        Comment comment = doc.createComment(
                "for special characters like < &, need CDATA");
        staff.appendChild(comment);

        Element bio = doc.createElement("bio");
        
        CDATASection cdataSection =
                doc.createCDATASection("HTML tag <code>testing</code>");
        bio.appendChild(cdataSection);
        staff.appendChild(bio);

        
        Element staff2 = doc.createElement("staff");
        
        rootElement.appendChild(staff2);
        staff2.setAttribute("id", "1002");

        Element name2 = doc.createElement("name");
        name2.setTextContent("yflow");
        staff2.appendChild(name2);

        Element role2 = doc.createElement("role");
        role2.setTextContent("admin");
        staff2.appendChild(role2);

        Element salary2 = doc.createElement("salary");
        salary2.setAttribute("currency", "EUD");
        salary2.setTextContent("8000");
        staff2.appendChild(salary2);

        Element bio2 = doc.createElement("bio");
        
        bio2.appendChild(doc.createCDATASection("a & b"));
        staff2.appendChild(bio2);

        
        writeXml(doc, System.out);

        
        

    }

    
    private static void writeXml(Document doc,
                                 OutputStream output)
            throws TransformerException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        
        

        
        

        
        

        
        

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);

        transformer.transform(source, result);

    }
}
