dbAdmin = db.getSiblingDB("admin");
dbAdmin.createUser({
    user: "marcos",
    pwd: "12345",
    roles: [{ role: "userAdminAnyDatabase", db: "admin" }],
    mechanisms: ["SCRAM-SHA-1"]
});

dbAdmin.auth({
    user: "marcos",
    pwd: "12345",
    mechanisms: ["SCRAM-SHA-1"],
    digestPassword: true
});

db = new Mongo().getDB("db_catalog");
db.createCollection('test', { capped: false });
db.test.insertOne({ "test": "test-catalog" });