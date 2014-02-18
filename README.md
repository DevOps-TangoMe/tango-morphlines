tango-morphlines
================

Collection of morphlines related classes used at Tango


License
-------

This is released under Apache License v2


Usage
-----

Import "com.cloudera.**" in your morphline configuration.
Example:
  importCommands : ["com.cloudera.**", "org.apache.solr.**", "com.tango.morphlines.**"]


Commands
--------

This package adds the new following commands:

* cleanRecords: clean a record of all attachments


Building
--------

This project uses maven for building all the artefacts.
You can build it with the following command:
    mvn clean install

This will build the following artefacts:
* target/tango-morphlines-1.0.0-SNAPSHOT-dist.tar.gz
  The tarball can be directly unpacked into Apache Flume plugins.d directory

* target/rpm/flume-tango-morphlines/RPMS/noarch/flume-tango-morphlines-1.0.0-SNAPSHOT*.noarch.rpm
  This package will install itself on top of Apache Flume package and be ready for use right away.


