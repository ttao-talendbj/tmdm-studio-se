// ============================================================================
//
// Copyright (C) 2006-2018 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.core.migrate;

import java.util.Date;
import java.util.GregorianCalendar;

import org.talend.core.model.migration.AbstractItemMigrationTask;
import org.talend.core.model.properties.Item;
import org.talend.mdm.repository.ui.wizards.imports.OperatorUpdatorProvider;


/**
 * created by liusongbo on Apr 18, 2016
 *
 */
public class UpdateOperatorMigrationTask extends AbstractItemMigrationTask {

    public Date getOrder() {
        GregorianCalendar gc = new GregorianCalendar(2016, 4, 15, 0, 0, 0);
        return gc.getTime();
    }

    @Override
    public ExecutionResult execute(Item item) {
        OperatorUpdatorProvider.instance().updateOperator(item);

        return ExecutionResult.SUCCESS_NO_ALERT;
    }
}
