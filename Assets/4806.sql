CREATE TABLE "student" (
  "id" int,
  "topic_id" int,
  "name" varchar
);

CREATE TABLE "prof" (
  "id" int,
  "name" varchar,
  "topic_in" varchar
);

CREATE TABLE "coordinator" (
  "id" int,
  "name" varchar
);

CREATE TABLE "room" (
  "id" int,
  "availability" boolean,
  "assigner" coordinator
);

CREATE TABLE "topic" (
  "id" int,
  "subject" varchar,
  "description" varchar,
  "program_restrictions" varchar,
  "topic_prof" int,
  "maximum_students" varchar,
  "current_students" int,
  "dead_line" datetime,
  "container" varchar
);

CREATE TABLE "event" (
  "id" int,
  "assigner" coordinator,
  "title" varchar,
  "description" varchar,
  "assigned_room" room_id,
  "event_date" datetime
);

CREATE TABLE "topicList" (
  "id" int,
  "topic" topic.id
);

ALTER TABLE "topic" ADD FOREIGN KEY ("topic_prof") REFERENCES "prof" ("id");

ALTER TABLE "topic" ADD FOREIGN KEY ("current_students") REFERENCES "student" ("id");

ALTER TABLE "topic" ADD FOREIGN KEY ("id") REFERENCES "prof" ("topic_in");

ALTER TABLE "topic" ADD FOREIGN KEY ("id") REFERENCES "topicList" ("topic");

ALTER TABLE "event" ADD FOREIGN KEY ("assigned_room") REFERENCES "room" ("id");

ALTER TABLE "event" ADD FOREIGN KEY ("assigner") REFERENCES "coordinator" ("id");

ALTER TABLE "topic" ADD FOREIGN KEY ("id") REFERENCES "student" ("topic_id");