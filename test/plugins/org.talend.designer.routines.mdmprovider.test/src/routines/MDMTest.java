// ============================================================================
//
// Copyright (C) 2006-2015 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package routines;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 * DOC class global comment. Detailled comment
 */

@SuppressWarnings("nls")
public class MDMTest {

    MDM mdm = new MDM();

    @Test
    public void testGetLanguageVariant() {
        String result = mdm.getLanguageVariant("EN", "[EN:example : it doesn t work][FR:exemple : ça ne fonctionne pas]");
        assertEquals("example : it doesn t work", result);
    }

    @Test
    public void testSetLanguageVariant() {
        String result = mdm.setLanguageVariant("FR", "exemple : ça ne fonctionne pas", "example : it doesn t work", "EN", true);
        assertEquals("[EN:example : it doesn t work][FR:exemple : ça ne fonctionne pas]", result);
    }

}
