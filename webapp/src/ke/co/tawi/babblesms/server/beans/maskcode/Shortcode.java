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
package ke.co.tawi.babblesms.server.beans.maskcode;

import ke.co.tawi.babblesms.server.beans.StorableBean;

/**
 * An SMS short code.
 * <p>
 *  
 * @author <a href="mailto:michael@tawi.mobi">Michael Wakahe</a>
 */
public class Shortcode extends StorableBean {

    private String codenumber;
    private String accountuuid;
    private String networkuuid;

    
    /**
     * 
     */
    public Shortcode() {
        super();
        accountuuid = "";
        networkuuid = "";
    }
    
    public String getCodenumber() {
        return codenumber ;
    }

    public void setCodenumber(String codenumber ) {
        this.codenumber  = codenumber ;
    }

    public String getAccountuuid() {
        return accountuuid ;
    }

    public void setAccountuuid(String accountuuid ) {
        this.accountuuid  = accountuuid ;
    }

    public String getNetworkuuid() {
        return networkuuid;
    }

    public void setNetworkuuid(String networkuuid) {
        this.networkuuid = networkuuid;
    }

    
    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Shortcode ");
        builder.append("[uuid=");
        builder.append(getUuid());
        builder.append(", codenumber=");
        builder.append(codenumber);
        builder.append(", accountuuid=");
        builder.append(accountuuid);
        builder.append(", networkuuid=");
        builder.append(networkuuid);
        builder.append("]");
        return builder.toString();
    }

}
