/*
 * (c) Kitodo. Key to digital objects e. V. <contact@kitodo.org>
 *
 * This file is part of the Kitodo project.
 *
 * It is licensed under GNU General Public License version 3 or later.
 *
 * For the full copyright and license information, please read the
 * GPL3-License.txt file that was distributed with this source code.
 */

package org.kitodo.production.forms.dataeditor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kitodo.api.Metadata;
import org.kitodo.api.dataeditor.rulesetmanagement.StructuralElementViewInterface;
import org.kitodo.api.dataformat.IncludedStructuralElement;
import org.kitodo.api.dataformat.MediaUnit;
import org.kitodo.exceptions.InvalidMetadataValueException;
import org.kitodo.exceptions.NoSuchMetadataFieldException;
import org.kitodo.production.forms.createprocess.ProcessDetail;
import org.kitodo.production.forms.createprocess.ProcessFieldedMetadata;
import org.kitodo.production.helper.Helper;
import org.kitodo.production.interfaces.RulesetSetupInterface;

/**
 * Backing bean for the metadata panel of the metadata editor.
 */
public class MetadataPanel implements Serializable {

    private static final Logger logger = LogManager.getLogger(MetadataPanel.class);

    private String addMetadataKeySelectedItem = "";

    private Collection<Metadata> clipboard = new ArrayList<>();

    private final RulesetSetupInterface rulesetSetup;

    private ProcessFieldedMetadata logicalMetadataTable = ProcessFieldedMetadata.EMPTY;
    private ProcessFieldedMetadata physicalMetadataTable = ProcessFieldedMetadata.EMPTY;

    MetadataPanel(RulesetSetupInterface rulesetSetup) {
        this.rulesetSetup = rulesetSetup;
    }

    /**
     * Adds an empty table line with the given type.
     */
    public void addMetadataEntry() {
        try {
            logicalMetadataTable.addAdditionallySelectedField(addMetadataKeySelectedItem);
        } catch (NoSuchMetadataFieldException e) {
            Helper.setErrorMessage(e.getLocalizedMessage());
        }
    }

    /**
     * Empties the metadata panel.
     */
    public void clear() {
        logicalMetadataTable = ProcessFieldedMetadata.EMPTY;
        physicalMetadataTable = ProcessFieldedMetadata.EMPTY;
        clipboard.clear();
        addMetadataKeySelectedItem = "";
    }

    /**
     * Set addMetadataKeySelectedItem.
     *
     * @param addMetadataKeySelectedItem as java.lang.String
     */
    public void setAddMetadataKeySelectedItem(String addMetadataKeySelectedItem) {
        this.addMetadataKeySelectedItem = addMetadataKeySelectedItem;
    }

    Collection<Metadata> getClipboard() {
        return clipboard;
    }

    /**
     * Returns the rows of logical metadata that JSF has to display.
     *
     * @return the rows of logical metadata
     */
    public List<ProcessDetail> getLogicalMetadataRows() {
        return logicalMetadataTable.getRows();
    }

    /**
     * Returns the rows of physical metadata that JSF has to display.
     *
     * @return the rows of physical metadata
     */
    public List<ProcessDetail> getPhysicalMetadataRows() {
        return physicalMetadataTable.getRows();
    }

    void showLogical(Optional<IncludedStructuralElement> optionalStructure) {
        if (optionalStructure.isPresent()) {
            StructuralElementViewInterface divisionView = rulesetSetup.getRuleset().getStructuralElementView(
                    optionalStructure.get().getType(), rulesetSetup.getAcquisitionStage(), rulesetSetup.getPriorityList());
            logicalMetadataTable = new ProcessFieldedMetadata(optionalStructure.get(), divisionView);
        } else {
            logicalMetadataTable = ProcessFieldedMetadata.EMPTY;
        }

    }

    void showPageInLogical(MediaUnit mediaUnit) {
        if (Objects.nonNull(mediaUnit)) {
            StructuralElementViewInterface divisionView = rulesetSetup.getRuleset().getStructuralElementView(
                    mediaUnit.getType(), rulesetSetup.getAcquisitionStage(), rulesetSetup.getPriorityList());
            logicalMetadataTable = new ProcessFieldedMetadata(mediaUnit, divisionView);
        } else {
            logicalMetadataTable = ProcessFieldedMetadata.EMPTY;
        }

    }

    void showPhysical(Optional<MediaUnit> optionalMediaUnit) {
        if (optionalMediaUnit.isPresent() && Objects.nonNull(optionalMediaUnit.get().getType())) {
            StructuralElementViewInterface divisionView = rulesetSetup.getRuleset().getStructuralElementView(
                    optionalMediaUnit.get().getType(), rulesetSetup.getAcquisitionStage(), rulesetSetup.getPriorityList());
            physicalMetadataTable = new ProcessFieldedMetadata(optionalMediaUnit.get(), divisionView);
        } else {
            physicalMetadataTable = ProcessFieldedMetadata.EMPTY;
        }

    }

    void preserve() {
        try {
            this.preserveLogical();
            this.preservePhysical();
        } catch (InvalidMetadataValueException | NoSuchMetadataFieldException e) {
            logger.info(e.getMessage());
        }
    }

    void preserveLogical() throws InvalidMetadataValueException, NoSuchMetadataFieldException {
        logicalMetadataTable.preserve();
    }

    void preservePhysical() throws InvalidMetadataValueException, NoSuchMetadataFieldException {
        physicalMetadataTable.preserve();
    }
}
