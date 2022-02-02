package in.sts.gradleproject.xmlreader;




import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import in.sts.gradleproject.daos.EmployeeDao;
import in.sts.gradleproject.models.Address;
import in.sts.gradleproject.models.Employee;
import in.sts.gradleproject.models.Salary;
import in.sts.gradleproject.service.AddressService;
import in.sts.gradleproject.service.EmployeeService;
import in.sts.gradleproject.service.SalaryService;
import in.sts.gradleproject.tagnameinterface.Tagnames;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;


//..............................READING AND STORING XML SIMULTANEOUSLY TO DATBASE.......................................................


public class EmployeeReader 
{  
	AddressService addressservice=new AddressService();

	Employee empmodel=new Employee();

	Salary salarymodel=new Salary();
	SalaryService salaryservice=new SalaryService();
	EmployeeService employeeservice=new EmployeeService();
	EmployeeDao empdao=new EmployeeDao();
	HashSet<Employee> hashset=new HashSet<>();
	HashSet<Employee> hashset3=new HashSet<>();
	
	final Logger logger=Logger.getLogger("EmployeeReader.class");

	public void employeeRead(String xml,HashSet<Employee> hashset2) throws Exception

	{









		try {

			//			xml="employee.xml";
			//.........................................Employee data fetch here  ...............................................................


			NodeList nodeList =Reader.reader(Tagnames.Employee,xml) ;//gets all the Employee node in the XML


			for (int itr = 0; itr < nodeList.getLength(); itr++)   // run the loop based on the no of Employee node in XML 
			{  
				//				logger.info(nodeList.getLength());
				Node node = nodeList.item(itr);  // gets the Employee node based on the index e.g if the its the First employee tag its index is 0
				logger.info("\nNode Name :" + node.getNodeName()+" "+(itr+1));  
				if (node.getNodeType() == Node.ELEMENT_NODE)   
				{   

					// .......set and read the XmL simultaneously store it to the data...............................................
					Element eElement = (Element) node; 

					int id=Integer.parseInt(eElement.getElementsByTagName(Tagnames.Id).item(0).getTextContent().trim());
					int report=Integer.parseInt(eElement.getElementsByTagName(Tagnames.Reportingto).item(0).getTextContent().trim());
					String designation=eElement.getElementsByTagName(Tagnames.Designation).item(0).getTextContent().trim();
					String fname=eElement.getElementsByTagName(Tagnames.Firstname).item(0).getTextContent().trim();
					String lname=eElement.getElementsByTagName(Tagnames.Lastname).item(0).getTextContent().trim();

					Employee empmodel2=new Employee(id, report,designation,  fname, lname);
					//					hashset.add(empmodel2);
//					employeeservice.Employeeservice(id,report,designation, fname, lname);

					//,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,

					//....................................................................................................................



					//......................................Fetch  Address details here ...........................................................

					NodeList addressnodeList = eElement.getElementsByTagName(Tagnames.Address) ;

					for (int k = 0; k <eElement.getElementsByTagName(Tagnames.Address).getLength() ; k++)   
					{  
//						logger.info(addressnodeList.getLength());
						Node addressnode = addressnodeList.item(k);  
//						logger.info("\nNode Name :" + addressnode.getNodeName());  
						if (addressnode.getNodeType() == Node.ELEMENT_NODE)   
						{   
							Element addressElement = (Element)addressnode; 

							// ..................set and read the XmL simultaneously store it to the data...............................


							String city=addressElement.getElementsByTagName(Tagnames.City).item(0).getTextContent().trim();
							String country=addressElement.getElementsByTagName(Tagnames.Country).item(0).getTextContent().trim();
							int pincode=Integer.parseInt(addressElement.getElementsByTagName(Tagnames.Pincode).item(0).getTextContent().trim());


							Address address=new Address(city,country,pincode);
							empmodel.setAddressmodel(address);
//							addressservice.addressDetails(id,city, country, pincode);
							//,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
						}
					}


					//...............................................................................................................................					






					//...........................................Fetch Salary Data here..................................................


					empmodel.setSalarymodel(salarymodel);//set the Salary model linked with Employee model

					NodeList salarynodeList =eElement.getElementsByTagName(Tagnames.Salary);//Salary node in XML
					for (int i = 0; i < eElement.getElementsByTagName(Tagnames.Salary).getLength(); i++) {
						Node s=salarynodeList.item(i);
//						logger.info("\nNode Name :" + s.getNodeName());  
						//						logger.info(salarynodeList.getLength());
						ArrayList<Salary> salarylist=new ArrayList<>();

						if(s.getNodeType()==Node.ELEMENT_NODE)
						{
							Element salary=(Element)s;

							NodeList yearnodelist = salary.getElementsByTagName(Tagnames.Year);//Child node of the salary node
							for(int l=0;l<salary.getElementsByTagName(Tagnames.Year).getLength();l++)
							{
								Node yearnode = yearnodelist.item(l);
								if(yearnode.getNodeType()==Node.ELEMENT_NODE)
								{
									Element year=(Element) yearnode;
									//									logger.info("Year  ="+year.getTagName()+" "+year.getAttribute("name"));

									int yearof=Integer.parseInt(year.getAttribute("name"));//gets the attribute value of the year node
									int numberofmonths=year.getElementsByTagName(Tagnames.Month).getLength();
									//									logger.info(numberofmonths);
									for(int j=0;j<numberofmonths;j++)//current no of months and amount child node present in the current year node
									{
										String month=year.getElementsByTagName(Tagnames.Month).item(j).getTextContent().trim();
										int amount=Integer.parseInt(year.getElementsByTagName(Tagnames.Amount).item(j).getTextContent().toString().trim());
										
										Salary salary2=new Salary(month,amount,yearof);
										empmodel.setSalarymodel(salary2);
										salarylist.add(salary2);
										empmodel.getSalarymodel().setSalarylist(salarylist);

//										salaryservice.salaryDetails(id,yearof, month, amount);

									}
								}
							}
							Employee empmodel3=new Employee(id, report,designation,  fname, lname,empmodel.getAddressmodel(),empmodel.getSalarymodel());

							hashset3.add(empmodel3);
							
							hashset2.addAll(hashset3);

//							empdao.employeedetailsInsert(empmodel);
							hashset3.clear();

						}
					}

					//..................................................................................................................................




				}  



			}

			
//			for(Salary s:empmodel.getSalarymodel().getSalarylist())
//			{
//				logger.info(" Salary is--"+s.getYear()+" "+s.getMonth()+" "+s.getAmount());
//			}
			//			empdao.employeedetailsInsert(empmodel);



		} catch (ParserConfigurationException e) {

			logger.error("ParserConfiguration Exception occurs check your file name is proper or not?");
		} catch (SAXException e) {

			logger.error(" SAXException occurs check your Xml file is properply wriiten or not ");
		} catch (IOException e) {

			logger.error("Throwing Input /Output Exception");
		}




	}


}

