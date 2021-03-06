/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ivankuo.com.itbon2018.data.db

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.migration.Migration

import ivankuo.com.itbon2018.data.model.Repo
import ivankuo.com.itbon2018.data.model.RepoSearchResult

/**
 * Main database description.
 */
@Database(entities = [(RepoSearchResult::class), (Repo::class)], version = 2)
abstract class GithubDb : RoomDatabase() {

    abstract fun repoDao(): RepoDao

    companion object {

        val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE Repo " + " ADD COLUMN html_url TEXT")
            }
        }
    }
}