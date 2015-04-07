/**
 * Copyright 2015 Tawi Commercial Services Ltd
 * 
 * Licensed under the Open Software License, Version 3.0 (the “License”); you may
 * not use this file except in compliance with the License. You may obtain a copy
 * of the License at:
 * http://opensource.org/licenses/OSL-3.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an “AS IS” BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied.
 * 
 * See the License for the specific language governing permissions and limitations
 * under the License.
 */
package ke.co.tawi.babblesms.server.persistence.contacts;

import java.util.Date;

import static org.junit.Assert.*;

import java.util.List;

import ke.co.tawi.babblesms.server.beans.account.Account;
import ke.co.tawi.babblesms.server.beans.contact.Group;
import ke.co.tawi.babblesms.server.beans.contact.Phone;
import ke.co.tawi.babblesms.server.persistence.accounts.AccountsDAO;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Tests our persistence for {@link Group}.
 * <p>
 *  
 * @author <a href="mailto:michael@tawi.mobi">Michael Wakahe</a>
 */
public class TestGroupDAO {

    final String DB_NAME = "babblesmsdb";
    final String DB_HOST = "localhost";
    final String DB_USERNAME = "babblesms";
    final String DB_PASSWD = "Hymfatsh8";
    final int DB_PORT = 5432;

    final String GROUP_UUID = "90156930-3a58-4457-9959-f192c8964f34", GROUP_UUID_NEW = "f8wk681d2e6-84f2-45ff-914c-522a3b076141";

    final String NAME = "vanitied",
            NAME_NEW = "kentgroup",
            NAME_UPDATE = "ksantogroup";

    final String DESCR = "contains two or three times as many",
            DESCR_NEW = "all members of KENT group",
            DESCR_UPDATE = "all members of Ksanto group";

    final String ACCUUID = "C937CE62-C4A9-131F-C96E-2DB8A9E886AB",
            ACCUUID_NEW = "650195B6-9357-C147-C24E-7FBDAEEC74ED";

    final String STATUSUUID = "5A13538F-AC41-FDE2-4CD6-B939FA03123B",
            STATUSUUID_NEW = "396F2C7F-961C-5C12-3ABF-867E7FD029E6";
    
    
    final String NEWGRN = "IT GEEKS";
    final String NEWGDESC = "IT GURUS FOUND AT CORNER VIEW";
    
    final Date CREATION_DATE = new Date(new Long("1413536189000") );  // 2014-10-04 03:08:06 (yyyy-MM-dd HH:mm:ss)

    
    
    private GroupDAO storage;
    private AccountsDAO storagenew;

    /**
     * Test method for
     * {@link ke.co.tawi.babblesms.server.persistence.items.Group#getGroup(java.lang.String)}.
     */
    @Ignore
    @Test
    public void testgetGroupString() {
        storage = new GroupDAO(DB_NAME, DB_HOST, DB_USERNAME, DB_PASSWD, DB_PORT);

        Group group = storage.getGroup(GROUP_UUID);
        assertEquals(group.getUuid(), GROUP_UUID);
        assertEquals(group.getName(), NAME);
        assertEquals(group.getDescription(), DESCR);
        //assertEquals(group.getCreationdate(), CREATION_DATE);
        assertEquals(group.getAccountsuuid(), ACCUUID);
        assertEquals(group.getStatusuuid(), STATUSUUID_NEW);

    }

    
    /**
     * method to test getting group belonging to a given account
     */
    @Test
    public void testGetGroupAccount(){
    	storagenew = new AccountsDAO(DB_NAME, DB_HOST, DB_USERNAME, DB_PASSWD, DB_PORT);
    	
    	Account account = storagenew.getAccount(ACCUUID);
    	
    	storage = new GroupDAO(DB_NAME, DB_HOST, DB_USERNAME, DB_PASSWD, DB_PORT);
    	
    	List<Group> list = storage.getGroups(account);
    	
    	assertEquals(list.size(), 20);
    	
    }
    
    
    /**
     * Test method for testing putting a group to the group table
     * {@link ke.co.tawi.babblesms.server.persistence.items.contact.Group#PutGroup(ke.co.tawi.babblesgroup.server.beans.contact.Group)}.
     *
     *
     *
     */
    @Ignore
    @Test
    public void testPutGroup() {
        storage = new GroupDAO(DB_NAME, DB_HOST, DB_USERNAME, DB_PASSWD, DB_PORT);

        Group group = new Group();
        group.setUuid(GROUP_UUID_NEW);
        group.setName(NAME_NEW);
        group.setDescription(DESCR_NEW);
        group.setAccountsuuid(ACCUUID_NEW);
        group.setStatusuuid(STATUSUUID_NEW);
       

        assertTrue(storage.putGroup(group));

        group = storage.getGroup(GROUP_UUID_NEW);
        assertEquals(group.getUuid(), GROUP_UUID_NEW);
        assertEquals(group.getName(), NAME_NEW);
        assertEquals(group.getDescription(), DESCR_NEW);
        //assertEquals(group.getCreationdate(), CREATION_DATE);
        assertEquals(group.getAccountsuuid(), ACCUUID_NEW);
        assertEquals(group.getStatusuuid(), STATUSUUID_NEW);

    }

    
    /**
     * method for testing updating the group table given a uuid and group object as parameters 
     */
    @Test
    public void  testUpdateGroup(){
    	storage = new GroupDAO(DB_NAME, DB_HOST, DB_USERNAME, DB_PASSWD, DB_PORT);
    	
    	
    	 Group group = new Group();
    	 group.setName(NEWGRN);
    	 group.setDescription(NEWGDESC);
    	 group.setAccountsuuid(ACCUUID);
    	 group.setUuid(GROUP_UUID);
    	 
    	 
    	 assertTrue(storage.updateGroup(GROUP_UUID, group));
    	 
    	 Group group1 = storage.getGroup(GROUP_UUID);
    	 
    	 assertEquals(group.getUuid(), GROUP_UUID);
         assertEquals(group1.getName(), NEWGRN);
         assertEquals(group.getDescription(), NEWGDESC);
         assertEquals(group.getAccountsuuid(), ACCUUID);
         assertEquals(group.getStatusuuid(), STATUSUUID_NEW);

    }
    
    }

