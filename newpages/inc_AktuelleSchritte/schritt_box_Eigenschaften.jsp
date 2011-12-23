<%@ page session="false" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://jsftutorials.net/htmLib" prefix="htm"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="x"%>

<%--
  ~ This file is part of the Goobi Application - a Workflow tool for the support of
  ~ mass digitization.
  ~
  ~ Visit the websites for more information.
  ~     - http://gdz.sub.uni-goettingen.de
  ~     - http://www.goobi.org
  ~     - http://launchpad.net/goobi-production
  ~
  ~ This program is free software; you can redistribute it and/or modify it under
  ~ the terms of the GNU General Public License as published by the Free Software
  ~ Foundation; either version 2 of the License, or (at your option) any later
  ~ version.
  ~
  ~ This program is distributed in the hope that it will be useful, but WITHOUT ANY
  ~ WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
  ~ PARTICULAR PURPOSE. See the GNU General Public License for more details. You
  ~ should have received a copy of the GNU General Public License along with this
  ~ program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
  ~ Suite 330, Boston, MA 02111-1307 USA
  --%>

<%-- ++++++++++++++++++++++++++++++++++++++++++++++++++++ --%>
<%-- ++++++++++++++++     Eigenschaftentabelle      ++++++++++++++++ --%>
<%-- ++++++++++++++++++++++++++++++++++++++++++++++++++++ --%>

<h:panelGroup
	rendered="#{AktuelleSchritteForm.mySchritt.eigenschaftenSize>0}">
	<h:form id="propform">
		<htm:h4 style="margin-top:15"
			rendered="#{AktuelleSchritteForm.modusBearbeiten!='schritteeigenschaft'}">
			<h:outputText value="#{msgs.erweiterteEigenschaften}" />
		</htm:h4>

		<x:dataTable id="eigenschaften" styleClass="standardTable"
			width="100%" cellspacing="1px" cellpadding="1px"
			headerClass="standardTable_Header" rowClasses="standardTable_Row1"
			columnClasses="standardTable_Column,standardTable_Column,standardTable_ColumnCentered"
			var="item"
			value="#{AktuelleSchritteForm.mySchritt.eigenschaftenList}"
			rendered="#{AktuelleSchritteForm.modusBearbeiten!='schritteeigenschaft'}">

			<h:column>
				<f:facet name="header">
					<h:outputText value="#{msgs.titel}" />
				</f:facet>
				<h:outputText value="#{item.titel}" />
			</h:column>

			<h:column>
				<f:facet name="header">
					<h:outputText value="#{msgs.wert}" />
				</f:facet>
				<h:outputText value="#{item.wert}" />
			</h:column>

			<h:column>
				<f:facet name="header">
					<h:outputText value="#{msgs.auswahl}" />
				</f:facet>
				<%-- Bearbeiten-Schaltknopf --%>
				<h:commandLink action="#{NavigationForm.Reload}" id="reload"
					title="#{msgs.bearbeiten}">
					<h:graphicImage value="/newpages/images/buttons/edit.gif" />
					<x:updateActionListener
						property="#{AktuelleSchritteForm.mySchrittEigenschaft}"
						value="#{item}" />
					<x:updateActionListener
						property="#{AktuelleSchritteForm.modusBearbeiten}"
						value="schritteeigenschaft" />
				</h:commandLink>
			</h:column>
		</x:dataTable>

		<%-- Neu-Schaltknopf --%>
		<h:commandLink action="#{AktuelleSchritteForm.SchrittEigenschaftNeu}" id="new"
			value="#{msgs.eigenschaftHinzufuegen}"
			title="#{msgs.eigenschaftHinzufuegen}"
			rendered="#{AktuelleSchritteForm.modusBearbeiten!='schritteeigenschaft' && 0==1}">
			<x:updateActionListener
				property="#{AktuelleSchritteForm.modusBearbeiten}"
				value="schritteeigenschaft" />
		</h:commandLink>


		<%-- ++++++++++++++++++++++++++++++++++++++++++++++++++++ --%>
		<%-- +++++++++++++++     Eigenschaft bearbeiten      ++++++++++++++++ --%>
		<%-- ++++++++++++++++++++++++++++++++++++++++++++++++++++ --%>

		<htm:h4 style="margin-top:15"
			rendered="#{AktuelleSchritteForm.modusBearbeiten=='schritteeigenschaft'}">
			<h:outputText value="#{msgs.eigenschaftBearbeiten}" />
		</htm:h4>
		<%-- Box für die Bearbeitung der Details --%>
		<htm:table cellpadding="3" cellspacing="0" width="100%" id="edittable"
			styleClass="eingabeBoxen"
			rendered="#{AktuelleSchritteForm.modusBearbeiten=='schritteeigenschaft'}">

			<htm:tr>
				<htm:td styleClass="eingabeBoxen_row1" colspan="2">
					<h:outputText value="#{msgs.eigenschaft}" />
				</htm:td>
			</htm:tr>

			<%-- Formular für die Bearbeitung der Eigenschaft --%>
			<htm:tr>
				<htm:td styleClass="eingabeBoxen_row2" colspan="2">

					<x:dataTable cellspacing="1px" cellpadding="1px" id="subtable"
						columnClasses="standardTable_Column,standardTable_Column,standardTable_ColumnCentered"
						var="item" value="#{AktuelleSchritteForm.mySchritt.eigenschaftenList}">

						<h:column>
							<h:outputText value="#{item.titel}" />
						</h:column>

						<h:column>
							<h:inputText value="#{item.wert}" style="width:500px" id="myvalue"/>
						</h:column>
					</x:dataTable>

					<h:panelGrid columns="2" rendered="false">
						<%-- Felder --%>
						<h:outputLabel for="eigenschafttitel" value="#{msgs.titel}" />
						<h:outputText id="eigenschafttitel"
							value="#{AktuelleSchritteForm.mySchrittEigenschaft.titel}" />

						<h:outputLabel for="eigenschaftwert" value="#{msgs.wert}" />
						<h:panelGroup>
							<h:inputText id="eigenschaftwert"
								style="width: 300px;margin-right:15px"
								value="#{AktuelleSchritteForm.mySchrittEigenschaft.wert}" />
						</h:panelGroup>
					</h:panelGrid>

				</htm:td>
			</htm:tr>

			<htm:tr>
				<htm:td styleClass="eingabeBoxen_row3" align="left">
					<h:commandButton value="#{msgs.abbrechen}" id="cancel"
						action="#{NavigationForm.Reload}" immediate="true">
						<x:updateActionListener
							property="#{AktuelleSchritteForm.modusBearbeiten}" value="" />
					</h:commandButton>
				</htm:td>
				<htm:td styleClass="eingabeBoxen_row3" align="right">
					<h:commandButton value="#{msgs.uebernehmen}" id="save"
						action="#{AktuelleSchritteForm.SchrittEigenschaftUebernehmen}">
						<x:updateActionListener
							property="#{AktuelleSchritteForm.modusBearbeiten}" value="" />
					</h:commandButton>
				</htm:td>
			</htm:tr>

		</htm:table>
		<%-- // Box für die Bearbeitung der Details --%>
	</h:form>
</h:panelGroup>
