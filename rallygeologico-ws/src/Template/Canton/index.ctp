<?php
/**
 * @var \App\View\AppView $this
 * @var \App\Model\Entity\Canton[]|\Cake\Collection\CollectionInterface $canton
 */
?>
<nav class="large-3 medium-4 columns" id="actions-sidebar">
    <ul class="side-nav">
        <li class="heading"><?= __('Actions') ?></li>
        <li><?= $this->Html->link(__('New Canton'), ['action' => 'add']) ?></li>
    </ul>
</nav>
<div class="canton index large-9 medium-8 columns content">
    <h3><?= __('Canton') ?></h3>
    <table cellpadding="0" cellspacing="0">
        <thead>
            <tr>
                <th scope="col"><?= $this->Paginator->sort('Name') ?></th>
                <th scope="col"><?= $this->Paginator->sort('DistrictName') ?></th>
                <th scope="col" class="actions"><?= __('Actions') ?></th>
            </tr>
        </thead>
        <tbody>
            <?php foreach ($canton as $canton): ?>
            <tr>
                <td><?= h($canton->Name) ?></td>
                <td><?= h($canton->DistrictName) ?></td>
                <td class="actions">
                    <?= $this->Html->link(__('View'), ['action' => 'view', $canton->Name]) ?>
                    <?= $this->Html->link(__('Edit'), ['action' => 'edit', $canton->Name]) ?>
                    <?= $this->Form->postLink(__('Delete'), ['action' => 'delete', $canton->Name], ['confirm' => __('Are you sure you want to delete # {0}?', $canton->Name)]) ?>
                </td>
            </tr>
            <?php endforeach; ?>
        </tbody>
    </table>
    <div class="paginator">
        <ul class="pagination">
            <?= $this->Paginator->first('<< ' . __('first')) ?>
            <?= $this->Paginator->prev('< ' . __('previous')) ?>
            <?= $this->Paginator->numbers() ?>
            <?= $this->Paginator->next(__('next') . ' >') ?>
            <?= $this->Paginator->last(__('last') . ' >>') ?>
        </ul>
        <p><?= $this->Paginator->counter(['format' => __('Page {{page}} of {{pages}}, showing {{current}} record(s) out of {{count}} total')]) ?></p>
    </div>
</div>
