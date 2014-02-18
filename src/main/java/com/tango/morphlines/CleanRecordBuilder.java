/**
 *  Copyright 2014 TangoMe Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.tango.morphlines;

import java.util.Collection;
import java.util.Collections;

import com.cloudera.cdk.morphline.api.Command;
import com.cloudera.cdk.morphline.api.CommandBuilder;
import com.cloudera.cdk.morphline.api.MorphlineContext;
import com.cloudera.cdk.morphline.api.Record;
import com.cloudera.cdk.morphline.base.AbstractCommand;
import com.cloudera.cdk.morphline.base.Fields;
import com.typesafe.config.Config;

/**
 * Command "cleanRecord" to clean a record of all attachments.
 * Does not take any parameter 
 */
public class CleanRecordBuilder implements CommandBuilder {

    private static final String CLEAN_RECORD = "cleanRecord";

    @Override
    public Command build(Config config, Command parent, Command child, MorphlineContext context) {
        return new CleanRecord(this, config, parent, child, context);
    }

    @Override
    public Collection<String> getNames() {
        return Collections.singletonList(CLEAN_RECORD);
    }

    private static final class CleanRecord extends AbstractCommand {

        protected CleanRecord(CommandBuilder builder, Config config, Command parent, Command child,
                MorphlineContext context) {
            super(builder, config, parent, child, context);
        }

        @Override
        protected boolean doProcess(Record record) {
            record.removeAll(Fields.ATTACHMENT_BODY);
            record.removeAll(Fields.ATTACHMENT_MIME_TYPE);
            record.removeAll(Fields.ATTACHMENT_CHARSET);
            record.removeAll(Fields.ATTACHMENT_NAME);

            return super.doProcess(record);
        }

    }

}
