package com.gadgetmedia.newsroom.repository.data.source.local

import android.arch.persistence.room.*
import com.gadgetmedia.newsroom.repository.data.News

/**
 * Data Access Object for the tasks table.
 */
@Dao
interface NewsDao {

    /**
     * Select all tasks from the tasks table.
     *
     * @return all tasks.
     */
    @Query("SELECT * FROM News")
    fun getTasks(): List<News>

    /**
     * Select a task by id.
     *
     * @param newsId the task id.
     * @return the task with newsId.
     */
    @Query("SELECT * FROM News WHERE entryid = :newsId")
    fun getTaskById(newsId: String): News?

    /**
     * Insert a news in the database. If the news already exists, replace it.
     *
     * @param task the task to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNews(news: News)

    /**
     * Update a task.
     *
     * @param task task to be updated
     * @return the number of News updated. This should always be 1.
     */
    @Update
    fun updateNews(news: News): Int

    /**
     * Update the complete status of a news
     *
     * @param newsId    id of the task
     * @param completed status to be updated
     */
    @Query("UPDATE News SET isRead = :isRead WHERE entryid = :newsId")
    fun updateCompleted(newsId: String, isRead: Boolean)

    /**
     * Delete a task by id.
     *
     * @return the number of News deleted. This should always be 1.
     */
    @Query("DELETE FROM News WHERE entryid = :newsId")
    fun deleteTaskById(newsId: String): Int

    /**
     * Delete all News.
     */
    @Query("DELETE FROM News")
    fun deleteNews()

    /**
     * Delete all completed News from the table.
     *
     * @return the number of News deleted.
     */
    @Query("DELETE FROM News WHERE isRead = 1")
    fun deleteCompletedNews(): Int
}
