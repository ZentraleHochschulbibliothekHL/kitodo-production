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

package org.kitodo.production.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Process DTO object.
 */
public class ProcessDTO extends BaseTemplateDTO {

    private ProjectDTO project;
    private List<BatchDTO> batches = new ArrayList<>();
    private List<PropertyDTO> properties = new ArrayList<>();
    private List<PropertyDTO> sortedCorrectionSolutionMessages = new ArrayList<>();
    private UserDTO blockedUser;
    private Integer progressClosed;
    private Integer progressInProcessing;
    private Integer progressOpen;
    private Integer progressLocked;
    private String wikiField;
    private String processBaseUri;
    private String batchID;
    private Integer parentID;
    private boolean hasChildren;
    private Integer sortHelperArticles;
    private Integer sortHelperDocstructs;
    private Integer sortHelperImages;
    private Integer sortHelperMetadata;

    /**
     * Get project.
     *
     * @return project as ProjectDTO
     */
    public ProjectDTO getProject() {
        return project;
    }

    /**
     * Set project.
     *
     * @param project
     *            as ProjectDTO
     */
    public void setProject(ProjectDTO project) {
        this.project = project;
    }

    /**
     * Get list of batches.
     *
     * @return list of batches as BatchDTO
     */
    public List<BatchDTO> getBatches() {
        return batches;
    }

    /**
     * Set list of batches.
     *
     * @param batches
     *            list of batches as BatchDTO
     */
    public void setBatches(List<BatchDTO> batches) {
        this.batches = batches;
    }

    /**
     * Get list of properties.
     *
     * @return list of properties as PropertyDTO
     */
    public List<PropertyDTO> getProperties() {
        if (Objects.isNull(this.properties)) {
            properties = new ArrayList<>();
        }
        return properties;
    }

    /**
     * Set list of properties.
     *
     * @param properties
     *            list of properties as PropertyDTO
     */
    public void setProperties(List<PropertyDTO> properties) {
        this.properties = properties;
    }

    /**
     * Get blocked user.
     *
     * @return blocked user as UserDTO
     */
    public UserDTO getBlockedUser() {
        return blockedUser;
    }

    /**
     * Set blocked user.
     *
     * @param blockedUser
     *            as UserDTO
     */
    public void setBlockedUser(UserDTO blockedUser) {
        this.blockedUser = blockedUser;
    }

    /**
     * Get list of sorted correction and solution messages.
     *
     * @return list of sorted correction and solution messages as PropertyDTO
     */
    public List<PropertyDTO> getSortedCorrectionSolutionMessages() {
        return sortedCorrectionSolutionMessages;
    }

    /**
     * Set list of sorted correction and solution messages.
     *
     * @param sortedCorrectionSolutionMessages
     *            as PropertyDTO
     */
    public void setSortedCorrectionSolutionMessages(List<PropertyDTO> sortedCorrectionSolutionMessages) {
        this.sortedCorrectionSolutionMessages = sortedCorrectionSolutionMessages;
    }

    /**
     * Get progress of closed tasks.
     *
     * @return progress of closed tasks as Integer
     */
    public Integer getProgressClosed() {
        return progressClosed;
    }

    /**
     * Set progress of closed tasks.
     *
     * @param progressClosed
     *            as Integer
     */
    public void setProgressClosed(Integer progressClosed) {
        this.progressClosed = progressClosed;
    }

    /**
     * Get progress of processed tasks.
     *
     * @return progress of processed tasks as Integer
     */
    public Integer getProgressInProcessing() {
        return progressInProcessing;
    }

    /**
     * Set progress of processed tasks.
     *
     * @param progressInProcessing
     *            as Integer
     */
    public void setProgressInProcessing(Integer progressInProcessing) {
        this.progressInProcessing = progressInProcessing;
    }

    /**
     * Get progress of locked tasks.
     *
     * @return progress of locked tasks as Integer
     */
    public Integer getProgressLocked() {
        return progressLocked;
    }

    /**
     * Set progress of locked tasks.
     *
     * @param progressLocked
     *            as Integer
     */
    public void setProgressLocked(Integer progressLocked) {
        this.progressLocked = progressLocked;
    }

    /**
     * Get wiki field.
     *
     * @return wiki field as String
     */
    public String getWikiField() {
        return wikiField;
    }

    /**
     * Set wiki field.
     *
     * @param wikiField
     *            as String
     */
    public void setWikiField(String wikiField) {
        this.wikiField = wikiField;
    }

    /**
     * Get progress of open tasks.
     *
     * @return progress of open tasks as Integer
     */
    public Integer getProgressOpen() {
        return progressOpen;
    }

    /**
     * Set progress of open tasks.
     *
     * @param progressOpen
     *            as Integer
     */
    public void setProgressOpen(Integer progressOpen) {
        this.progressOpen = progressOpen;
    }

    /**
     * Get process base URI as String.
     *
     * @return process base URI as String.
     */
    public String getProcessBaseUri() {
        return processBaseUri;
    }

    /**
     * Set process base URI as String.
     *
     * @param processBaseUri
     *            as String
     */
    public void setProcessBaseUri(String processBaseUri) {
        this.processBaseUri = processBaseUri;
    }

    /**
     * Get batch id(label) as String.
     *
     * @return batch id(label) as String.
     */
    public String getBatchID() {
        return batchID;
    }

    /**
     * Set batch id(label) as String.
     *
     * @param batchID
     *            as String
     */
    public void setBatchID(String batchID) {
        this.batchID = batchID;
    }

    /**
     * Get parentID.
     *
     * @return value of parentID
     */
    public Integer getParentID() {
        return parentID;
    }

    /**
     * Set parentID.
     *
     * @param parentID as java.lang.Integer
     */
    public void setParentID(Integer parentID) {
        this.parentID = parentID;
    }

    /**
     * Get hasChildren.
     *
     * @return value of hasChildren
     */
    public boolean hasChildren() {
        return hasChildren;
    }

    /**
     * Set hasChildren.
     *
     * @param hasChildren as boolean
     */
    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    /**
     * Get sort helper for articles.
     *
     * @return sort helper for articles as Integer
     */
    public Integer getSortHelperArticles() {
        return this.sortHelperArticles;
    }

    /**
     * Set sort helper for articles.
     *
     * @param sortHelperArticles
     *            as Integer
     */
    public void setSortHelperArticles(Integer sortHelperArticles) {
        this.sortHelperArticles = sortHelperArticles;
    }

    /**
     * Get sort helper for document structure.
     *
     * @return sort helper for document structure as Integer
     */
    public Integer getSortHelperDocstructs() {
        return this.sortHelperDocstructs;
    }

    /**
     * Set sort helper for document structure.
     *
     * @param sortHelperDocstructs
     *            as Integer
     */
    public void setSortHelperDocstructs(Integer sortHelperDocstructs) {
        this.sortHelperDocstructs = sortHelperDocstructs;
    }

    /**
     * Get sort helper for images.
     *
     * @return sort helper for images as Integer
     */
    public Integer getSortHelperImages() {
        return this.sortHelperImages;
    }

    /**
     * Set sort helper for images.
     *
     * @param sortHelperImages
     *            as Integer
     */
    public void setSortHelperImages(Integer sortHelperImages) {
        this.sortHelperImages = sortHelperImages;
    }

    /**
     * Get sort helper for metadata.
     *
     * @return sort helper for metadata as Integer
     */
    public Integer getSortHelperMetadata() {
        return this.sortHelperMetadata;
    }

    /**
     * Set sort helper for metadata.
     *
     * @param sortHelperMetadata
     *            as Integer
     */
    public void setSortHelperMetadata(Integer sortHelperMetadata) {
        this.sortHelperMetadata = sortHelperMetadata;
    }
}
